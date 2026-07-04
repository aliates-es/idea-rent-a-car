package com.ideorentacar.affiliate;

import java.time.Instant;

public class Affiliate {

private String id;
private String displayName;
private String referralCode;
private CommissionType commissionType;
private double commissionValue;
private AffiliateStatus status;
private String billingEmail;
private Instant createdAt;

public Affiliate() {
}

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getDisplayName() {
  return displayName;
}

public void setDisplayName(String displayName) {
  this.displayName = displayName;
}

public String getReferralCode() {
  return referralCode;
}

public void setReferralCode(String referralCode) {
  this.referralCode = referralCode;
}

public CommissionType getCommissionType() {
  return commissionType;
}

public void setCommissionType(CommissionType commissionType) {
  this.commissionType = commissionType;
}

public double getCommissionValue() {
  return commissionValue;
}

public void setCommissionValue(double commissionValue) {
  this.commissionValue = commissionValue;
}

public AffiliateStatus getStatus() {
  return status;
}

public void setStatus(AffiliateStatus status) {
  this.status = status;
}

public String getBillingEmail() {
  return billingEmail;
}

public void setBillingEmail(String billingEmail) {
  this.billingEmail = billingEmail;
}

public Instant getCreatedAt() {
  return createdAt;
}

public void setCreatedAt(Instant createdAt) {
  this.createdAt = createdAt;
}
}

enum CommissionType {
PERCENTAGE,
FIXED_AMOUNT
}

enum AffiliateStatus {
PENDING,
ACTIVE,
SUSPENDED
}
