package se.yrgo.inl2.dto;

import se.yrgo.inl2.entity.Customer;
import se.yrgo.inl2.entity.Vehicle;

import java.util.List;

public class CustomerVehiclesDTO {
    private Customer customer;
    private List<Vehicle> vehicles;

    public CustomerVehiclesDTO(Customer customer, List<Vehicle> vehicles) {
        this.customer = customer;
        this.vehicles = vehicles;
    }

    public Customer getCustomer() {
        return customer;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
