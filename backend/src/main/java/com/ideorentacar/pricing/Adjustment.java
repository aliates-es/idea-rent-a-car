package com.ideorentacar.pricing;

public class Adjustment {

private AdjustmentType type;
private double value;

public Adjustment() {
}

public Adjustment(AdjustmentType type, double value) {
this.type = type;
this.value = value;
}

public AdjustmentType getType() {
return type;
}

public void setType(AdjustmentType type) {
this.type = type;
}

public double getValue() {
return value;
}

public void setValue(double value) {
this.value = value;
}
}

enum AdjustmentType {
PERCENTAGE,
FIXED_AMOUNT
}
