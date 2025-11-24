package se.yrgo.inl2.dto;

import se.yrgo.inl2.entity.Customer;
import se.yrgo.inl2.entity.Vehicle;

import java.util.List;

public class CustomerVehiclesDTO {
    private int customerId;
    private String name;
    private String phoneNumber;
    private List<VehicleDTO> vehicles;

    public CustomerVehiclesDTO(Customer customer, List<Vehicle> vehicles) {
        this.customerId = customer.getId();
        this.name = customer.getName();
        this.phoneNumber = customer.getPhoneNumber();
        this.vehicles = vehicles.stream()
                .map(VehicleDTO::new)
                .toList();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }
}


