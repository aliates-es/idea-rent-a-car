package com.ideorentacar.rental;

import java.time.Instant;
import java.util.List;

public class Car {

  private String id;
  private String branchId;
  private String make;
  private String model;
  private int manufactureYear;
  private VehicleCategory category;
  private double odometerKm;
  private List<String> photoUrls;
  private CarStatus status;
  private Instant registeredAt;

  public Car() {
    }

  public Car(String id, String branchId, String make, String model, int manufactureYear, VehicleCategory category) {
    this.id = id;
    this.branchId = branchId;
    this.make = make;
    this.model = model;
    this.manufactureYear = manufactureYear;
    this.category = category;
    this.status = CarStatus.AVAILABLE;
    this.registeredAt = Instant.now();
    }

  public String getId() {
    return id;
    }

  public void setId(String id) {
    this.id = id;
    }

  public String getBranchId() {
    return branchId;
    }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
    }

  public String getMake() {
    return make;
    }

  public void setMake(String make) {
    this.make = make;
    }

  public String getModel() {
    return model;
    }

  public void setModel(String model) {
    this.model = model;
    }

  public int getManufactureYear() {
    return manufactureYear;
    }

  public void setManufactureYear(int manufactureYear) {
    this.manufactureYear = manufactureYear;
    }

  public VehicleCategory getCategory() {
    return category;
    }

  public void setCategory(VehicleCategory category) {
    this.category = category;
    }

  public double getOdometerKm() {
    return odometerKm;
    }

  public void setOdometerKm(double odometerKm) {
    this.odometerKm = odometerKm;
    }

  public List<String> getPhotoUrls() {
    return photoUrls;
    }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    }

  public CarStatus getStatus() {
    return status;
    }

  public void setStatus(CarStatus status) {
    this.status = status;
    }

  public Instant getRegisteredAt() {
    return registeredAt;
    }

  public void setRegisteredAt(Instant registeredAt) {
    this.registeredAt = registeredAt;
    }
  }
