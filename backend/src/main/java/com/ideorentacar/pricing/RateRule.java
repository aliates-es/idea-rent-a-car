package com.ideorentacar.pricing;

import com.ideorentacar.rental.VehicleCategory;

import java.time.Instant;

public class RateRule {

private String id;
private String name;
private VehicleCategory category;
private RuleType type;
private Instant validFrom;
private Instant validTo;
private Integer minAdvanceDays;
private Integer minDurationDays;
private Adjustment adjustment;
private int priority;
private boolean stackable;
private boolean active;

public RateRule() {
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public VehicleCategory getCategory() {
return category;
}

public void setCategory(VehicleCategory category) {
this.category = category;
}

public RuleType getType() {
return type;
}

public void setType(RuleType type) {
this.type = type;
}

public Instant getValidFrom() {
return validFrom;
}

public void setValidFrom(Instant validFrom) {
this.validFrom = validFrom;
}

public Instant getValidTo() {
return validTo;
}

public void setValidTo(Instant validTo) {
this.validTo = validTo;
}

public Integer getMinAdvanceDays() {
return minAdvanceDays;
}

public void setMinAdvanceDays(Integer minAdvanceDays) {
this.minAdvanceDays = minAdvanceDays;
}

public Integer getMinDurationDays() {
return minDurationDays;
}

public void setMinDurationDays(Integer minDurationDays) {
this.minDurationDays = minDurationDays;
}

public Adjustment getAdjustment() {
return adjustment;
}

public void setAdjustment(Adjustment adjustment) {
this.adjustment = adjustment;
}

public int getPriority() {
return priority;
}

public void setPriority(int priority) {
this.priority = priority;
}

public boolean isStackable() {
return stackable;
}

public void setStackable(boolean stackable) {
this.stackable = stackable;
}

public boolean isActive() {
return active;
}

public void setActive(boolean active) {
this.active = active;
}
}

enum RuleType {
SEASON,
ADVANCE_BOOKING,
DURATION,
WEEKDAY,
SURCHARGE
}
