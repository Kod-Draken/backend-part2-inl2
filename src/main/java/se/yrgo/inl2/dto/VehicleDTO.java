package se.yrgo.inl2.dto;

import se.yrgo.inl2.entity.Vehicle;

public class VehicleDTO {
    private int id;
    private String licenceNumber;
    private String brand;
    private String model;
    private String productionYear;

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.licenceNumber = vehicle.getLicenseNumber();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.productionYear = vehicle.getProductionYear();
    }

    public int getId() {
        return id;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProductionYear() {
        return productionYear;
    }
}
