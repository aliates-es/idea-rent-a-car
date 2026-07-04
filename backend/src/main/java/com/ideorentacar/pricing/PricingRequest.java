package com.ideorentacar.pricing;

import com.ideorentacar.rental.VehicleCategory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PricingRequest {

private VehicleCategory category;
private Instant pickupAt;
private Instant dropoffAt;
private List<String> extraCodes = new ArrayList<>();

public VehicleCategory getCategory() {
  return category;
}

public void setCategory(VehicleCategory category) {
  this.category = category;
}

public Instant getPickupAt() {
  return pickupAt;
}

public void setPickupAt(Instant pickupAt) {
  this.pickupAt = pickupAt;
}

public Instant getDropoffAt() {
  return dropoffAt;
}

public void setDropoffAt(Instant dropoffAt) {
  this.dropoffAt = dropoffAt;
}

public List<String> getExtraCodes() {
  return extraCodes;
}

public void setExtraCodes(List<String> extraCodes) {
  this.extraCodes = extraCodes;
}
}
