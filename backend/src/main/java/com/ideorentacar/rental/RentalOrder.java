package com.ideorentacar.rental;

import java.time.Instant;

public class RentalOrder {

private String id;
private String bookingId;
private double amount;
private String currency;
private PaymentStatus paymentStatus;
private String paymentProvider;
private String providerReference;
private Instant paidAt;

public RentalOrder() {
}

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getBookingId() {
  return bookingId;
}

public void setBookingId(String bookingId) {
  this.bookingId = bookingId;
}

public double getAmount() {
  return amount;
}

public void setAmount(double amount) {
  this.amount = amount;
}

public String getCurrency() {
  return currency;
}

public void setCurrency(String currency) {
  this.currency = currency;
}

public PaymentStatus getPaymentStatus() {
  return paymentStatus;
}

public void setPaymentStatus(PaymentStatus paymentStatus) {
  this.paymentStatus = paymentStatus;
}

public String getPaymentProvider() {
  return paymentProvider;
}

public void setPaymentProvider(String paymentProvider) {
  this.paymentProvider = paymentProvider;
}

public String getProviderReference() {
  return providerReference;
}

public void setProviderReference(String providerReference) {
  this.providerReference = providerReference;
}

public Instant getPaidAt() {
  return paidAt;
}

public void setPaidAt(Instant paidAt) {
  this.paidAt = paidAt;
}
}
