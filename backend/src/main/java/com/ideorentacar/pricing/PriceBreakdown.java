package com.ideorentacar.pricing;

import java.util.ArrayList;
import java.util.List;

public class PriceBreakdown {

private double baseAmount;
private List<AppliedAdjustment> appliedAdjustments = new ArrayList<>();
private double extrasAmount;
private double totalAmount;
private boolean estimateOnly;

public double getBaseAmount() {
  return baseAmount;
}

public void setBaseAmount(double baseAmount) {
  this.baseAmount = baseAmount;
}

public List<AppliedAdjustment> getAppliedAdjustments() {
  return appliedAdjustments;
}

public void setAppliedAdjustments(List<AppliedAdjustment> appliedAdjustments) {
  this.appliedAdjustments = appliedAdjustments;
}

public double getExtrasAmount() {
  return extrasAmount;
}

public void setExtrasAmount(double extrasAmount) {
  this.extrasAmount = extrasAmount;
}

public double getTotalAmount() {
  return totalAmount;
}

public void setTotalAmount(double totalAmount) {
  this.totalAmount = totalAmount;
}

public boolean isEstimateOnly() {
  return estimateOnly;
}

public void setEstimateOnly(boolean estimateOnly) {
  this.estimateOnly = estimateOnly;
}

public static class AppliedAdjustment {

private String ruleName;
private double amount;

public AppliedAdjustment() {
}

public AppliedAdjustment(String ruleName, double amount) {
this.ruleName = ruleName;
this.amount = amount;
}

public String getRuleName() {
  return ruleName;
}

public void setRuleName(String ruleName) {
  this.ruleName = ruleName;
}

public double getAmount() {
  return amount;
}

public void setAmount(double amount) {
  this.amount = amount;
}
}
}
