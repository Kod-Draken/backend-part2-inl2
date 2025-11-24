package se.yrgo.inl2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String licenseNumber;
    private String brand;
    private String model;
    private String productionYear;

    @ManyToOne
    @JoinColumn(name = "id")
    private Customer customer;

    public Vehicle() {}

    public Vehicle(String licenseNumber, String brand, String model, String productionYear) {
        this.licenseNumber = licenseNumber;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
