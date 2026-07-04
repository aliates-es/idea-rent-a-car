package com.ideorentacar.pricing;

public class ExtraOption {

private String code;
private String description;
private PricingMode pricingMode;
private double price;
private boolean autoApplied;

public ExtraOption() {
}

public String getCode() {
  return code;
}

public void setCode(String code) {
  this.code = code;
}

public String getDescription() {
  return description;
}

public void setDescription(String description) {
  this.description = description;
}

public PricingMode getPricingMode() {
  return pricingMode;
}

public void setPricingMode(PricingMode pricingMode) {
  this.pricingMode = pricingMode;
}

public double getPrice() {
  return price;
}

public void setPrice(double price) {
  this.price = price;
}

public boolean isAutoApplied() {
  return autoApplied;
}

public void setAutoApplied(boolean autoApplied) {
  this.autoApplied = autoApplied;
}
}

enum PricingMode {
PER_DAY,
ONE_TIME
}
