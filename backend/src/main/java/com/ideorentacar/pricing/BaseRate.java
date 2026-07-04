package com.ideorentacar.pricing;

import com.ideorentacar.rental.VehicleCategory;

public class BaseRate {

private VehicleCategory category;
private double dailyRate;
private double securityDeposit;
private int includedKmPerDay;

public BaseRate() {
}

public VehicleCategory getCategory() {
  return category;
}

public void setCategory(VehicleCategory category) {
  this.category = category;
}

public double getDailyRate() {
  return dailyRate;
}

public void setDailyRate(double dailyRate) {
  this.dailyRate = dailyRate;
}

public double getSecurityDeposit() {
  return securityDeposit;
}

public void setSecurityDeposit(double securityDeposit) {
  this.securityDeposit = securityDeposit;
}

public int getIncludedKmPerDay() {
  return includedKmPerDay;
}

public void setIncludedKmPerDay(int includedKmPerDay) {
  this.includedKmPerDay = includedKmPerDay;
}
}
