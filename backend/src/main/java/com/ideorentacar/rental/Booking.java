package com.ideorentacar.rental;

import java.time.Instant;

public class Booking {

private String id;
private String carId;
private String customerId;
private String pickupLocationId;
private String dropoffLocationId;
private Instant pickupAt;
private Instant dropoffAt;
private BookingStatus status;
private String affiliateCode;
private Instant createdAt;

public Booking() {
}

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getCarId() {
  return carId;
}

public void setCarId(String carId) {
  this.carId = carId;
}

public String getCustomerId() {
  return customerId;
}

public void setCustomerId(String customerId) {
  this.customerId = customerId;
}

public String getPickupLocationId() {
  return pickupLocationId;
}

public void setPickupLocationId(String pickupLocationId) {
  this.pickupLocationId = pickupLocationId;
}

public String getDropoffLocationId() {
  return dropoffLocationId;
}

public void setDropoffLocationId(String dropoffLocationId) {
  this.dropoffLocationId = dropoffLocationId;
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

public BookingStatus getStatus() {
  return status;
}

public void setStatus(BookingStatus status) {
  this.status = status;
}

public String getAffiliateCode() {
  return affiliateCode;
}

public void setAffiliateCode(String affiliateCode) {
  this.affiliateCode = affiliateCode;
}

public Instant getCreatedAt() {
  return createdAt;
}

public void setCreatedAt(Instant createdAt) {
  this.createdAt = createdAt;
}
}
