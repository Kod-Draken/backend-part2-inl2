package se.yrgo.inl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.inl2.entity.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    public List<Vehicle> findVehicleByCustomerId(int customerId);
    public List<Vehicle> findVehiclesByBrand(String brand);

}
