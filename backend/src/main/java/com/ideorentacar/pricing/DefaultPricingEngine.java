package com.ideorentacar.pricing;

import com.ideorentacar.rental.VehicleCategory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class DefaultPricingEngine implements PricingEngine {

private final List<BaseRate> baseRates;
private final List<RateRule> rateRules;
private final List<ExtraOption> extraOptions;

public DefaultPricingEngine(List<BaseRate> baseRates, List<RateRule> rateRules, List<ExtraOption> extraOptions) {
this.baseRates = baseRates;
this.rateRules = rateRules;
this.extraOptions = extraOptions;
}

@Override
public PriceBreakdown calculate(PricingRequest request) {
long durationDays = Math.max(1, Duration.between(request.getPickupAt(), request.getDropoffAt()).toDays());
long advanceDays = Duration.between(Instant.now(), request.getPickupAt()).toDays();

BaseRate baseRate = findBaseRate(request.getCategory());
double baseAmount = baseRate.getDailyRate() * durationDays;

PriceBreakdown breakdown = new PriceBreakdown();
breakdown.setBaseAmount(baseAmount);

double runningTotal = baseAmount;
RateRule bestExclusiveRule = null;

for (RateRule rule : rateRules) {
if (!rule.isActive()) continue;
if (rule.getCategory() != null && rule.getCategory() != request.getCategory()) continue;
if (!ruleApplies(rule, request, advanceDays, durationDays)) continue;

if (!rule.isStackable()) {
if (bestExclusiveRule == null || rule.getPriority() > bestExclusiveRule.getPriority()) {
bestExclusiveRule = rule;
}
continue;
}

double adjustmentAmount = applyAdjustment(rule.getAdjustment(), baseAmount);
runningTotal += adjustmentAmount;
breakdown.getAppliedAdjustments().add(new PriceBreakdown.AppliedAdjustment(rule.getName(), adjustmentAmount));
}

if (bestExclusiveRule != null) {
double adjustmentAmount = applyAdjustment(bestExclusiveRule.getAdjustment(), baseAmount);
runningTotal += adjustmentAmount;
breakdown.getAppliedAdjustments().add(new PriceBreakdown.AppliedAdjustment(bestExclusiveRule.getName(), adjustmentAmount));
}

double extrasAmount = 0;
for (String code : request.getExtraCodes()) {
ExtraOption extra = findExtraOption(code);
if (extra == null) continue;
extrasAmount += extra.getPricingMode() == PricingMode.PER_DAY ? extra.getPrice() * durationDays : extra.getPrice();
}

for (ExtraOption extra : extraOptions) {
if (extra.isAutoApplied() && !request.getExtraCodes().contains(extra.getCode())) {
extrasAmount += extra.getPricingMode() == PricingMode.PER_DAY ? extra.getPrice() * durationDays : extra.getPrice();
}
}

breakdown.setExtrasAmount(extrasAmount);
breakdown.setTotalAmount(runningTotal + extrasAmount);
breakdown.setEstimateOnly(true);
return breakdown;
}

private boolean ruleApplies(RateRule rule, PricingRequest request, long advanceDays, long durationDays) {
if (rule.getType() == RuleType.SEASON) {
if (rule.getValidFrom() != null && request.getPickupAt().isBefore(rule.getValidFrom())) return false;
if (rule.getValidTo() != null && request.getPickupAt().isAfter(rule.getValidTo())) return false;
}
if (rule.getType() == RuleType.ADVANCE_BOOKING && rule.getMinAdvanceDays() != null) {
if (advanceDays < rule.getMinAdvanceDays()) return false;
}
if (rule.getType() == RuleType.DURATION && rule.getMinDurationDays() != null) {
if (durationDays < rule.getMinDurationDays()) return false;
}
return true;
}

private double applyAdjustment(Adjustment adjustment, double baseAmount) {
if (adjustment == null) return 0;
if (adjustment.getType() == AdjustmentType.PERCENTAGE) {
return baseAmount * (adjustment.getValue() / 100.0);
}
return adjustment.getValue();
}

private BaseRate findBaseRate(VehicleCategory category) {
for (BaseRate rate : baseRates) {
if (rate.getCategory() == category) return rate;
}
throw new IllegalStateException("No base rate configured for this category");
}

private ExtraOption findExtraOption(String code) {
for (ExtraOption extra : extraOptions) {
if (extra.getCode().equals(code)) return extra;
}
return null;
}
}
