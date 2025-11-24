package se.yrgo.inl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.inl2.entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findVehicleByCustomerId(int customerId);

    List<Vehicle> findVehiclesByBrand(String brand);

    Vehicle findVehicleById(int vehicleId);
}
