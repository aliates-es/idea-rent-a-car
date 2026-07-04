package com.ideorentacar.affiliate;

import java.time.Instant;

public class AffiliateConversion {

private String id;
private String affiliateId;
private String bookingId;
private double bookingAmount;
private double commissionAmount;
private ConversionStatus status;
private Instant convertedAt;

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getAffiliateId() {
  return affiliateId;
}

public void setAffiliateId(String affiliateId) {
  this.affiliateId = affiliateId;
}

public String getBookingId() {
  return bookingId;
}

public void setBookingId(String bookingId) {
  this.bookingId = bookingId;
}

public double getBookingAmount() {
  return bookingAmount;
}

public void setBookingAmount(double bookingAmount) {
  this.bookingAmount = bookingAmount;
}

public double getCommissionAmount() {
  return commissionAmount;
}

public void setCommissionAmount(double commissionAmount) {
  this.commissionAmount = commissionAmount;
}

public ConversionStatus getStatus() {
  return status;
}

public void setStatus(ConversionStatus status) {
  this.status = status;
}

public Instant getConvertedAt() {
  return convertedAt;
}

public void setConvertedAt(Instant convertedAt) {
  this.convertedAt = convertedAt;
}
}

enum ConversionStatus {
PENDING,
APPROVED,
PAID,
VOID
}
