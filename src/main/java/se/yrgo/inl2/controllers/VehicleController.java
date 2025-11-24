package se.yrgo.inl2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.inl2.entity.Customer;
import se.yrgo.inl2.entity.Vehicle;
import se.yrgo.inl2.repository.CustomerRepository;
import se.yrgo.inl2.repository.VehicleRepository;

import java.util.List;

@RestController
public class VehicleController {

    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Skapa en REST-controller med följande metoder som:
     * skapar en fordon
     * Koppla en fordon till en kund
     * returnera en lista av alla kunder med fordon
     * returnerar en  lista  av alla fordon
     * returnerar alla fordon med deras märke (brand)
     * tar kunden namn och returnerar id.
     */
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(
            @RequestParam String name,
            @RequestParam String phone
    ) {
        if (name == null || phone == null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            customerRepository.save(new Customer(name, phone));
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> createVehicle(
            @RequestParam String licenceNumber,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String productionYear
    ) {
        if (licenceNumber == null || brand == null || model == null || productionYear == null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            vehicleRepository.save(new Vehicle(licenceNumber, brand, model, productionYear));
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/customer-id")
    public int getCustomerIdByName(@RequestParam String name) {
        return customerRepository.findCustomerIdByName(name);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomersWithVehicles() {
        return customerRepository.findCustomersWithVehicles();
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles-by-brand")
    public List<Vehicle> getVehiclesByBrand(
            @RequestParam String brand
    ) {
        return vehicleRepository.findVehiclesByBrand(brand);
    }
}
