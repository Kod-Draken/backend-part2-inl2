package se.yrgo.inl2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.inl2.dto.CustomerIdNameDTO;
import se.yrgo.inl2.dto.CustomerVehiclesDTO;
import se.yrgo.inl2.dto.VehicleDTO;
import se.yrgo.inl2.entity.Customer;
import se.yrgo.inl2.entity.Vehicle;
import se.yrgo.inl2.repository.CustomerRepository;
import se.yrgo.inl2.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MasterController {

    private CustomerRepository customerRepository;
    private VehicleRepository vehicleRepository;

    public MasterController(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }


    @PostMapping("/customer")
    public ResponseEntity<CustomerVehiclesDTO> createCustomer(
            @RequestParam String name,
            @RequestParam String phone
    ) {
        if (name == null || phone == null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            Customer newCustomer = new Customer(name, phone);
            customerRepository.save(newCustomer);
            return ResponseEntity.ok().body(new CustomerVehiclesDTO(newCustomer, new ArrayList<>()));
        }
    }

    @PostMapping("/vehicle")
    public ResponseEntity<VehicleDTO> createVehicle(
            @RequestParam String licenceNumber,
            @RequestParam String brand,
            @RequestParam String model,
            @RequestParam String productionYear
    ) {
        if (licenceNumber == null || brand == null || model == null || productionYear == null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            Vehicle newVehicle = new Vehicle(licenceNumber, brand, model, productionYear);
            vehicleRepository.save(newVehicle);
            return ResponseEntity.ok().body(new VehicleDTO(newVehicle));
        }
    }

    @PostMapping("/add-vehicle-to-customer")
    public ResponseEntity<CustomerVehiclesDTO> addVehicleToCustomer(
            @RequestParam int vehicleId,
            @RequestParam int customerId
    ) {
        if (vehicleId <= 0 || customerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        else {
            Vehicle vehicleToConnect = vehicleRepository.findVehicleById(vehicleId);
            Customer customerToConnect = customerRepository.findCustomerById(customerId);

            if (vehicleToConnect == null || customerToConnect == null || vehicleToConnect.getCustomer() != null) {
                return ResponseEntity.badRequest().build();
            }

            customerToConnect.getVehicles().add(vehicleToConnect);
            vehicleToConnect.setCustomer(customerToConnect);

            vehicleRepository.save(vehicleToConnect);
            customerRepository.save(customerToConnect);

            CustomerVehiclesDTO result = new CustomerVehiclesDTO(customerToConnect, customerToConnect.getVehicles());

            return ResponseEntity.ok().body(result);

        }
    }

    @GetMapping("/customer-id")
    public List<CustomerIdNameDTO> getCustomerIdByName(@RequestParam String name) {
        return customerRepository.findCustomerIdByName(name);
    }

    @GetMapping("/customers")
    public List<CustomerVehiclesDTO> getAllCustomersWithVehicles() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerVehiclesDTO> result = customers.stream()
                .map(customer -> new CustomerVehiclesDTO(customer, customer.getVehicles()))
                .toList();

        return result;
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(VehicleDTO::new).toList();
    }

    @GetMapping("/vehicles-by-brand")
    public List<VehicleDTO> getVehiclesByBrand(
            @RequestParam String brand
    ) {
        return vehicleRepository.findVehiclesByBrand(brand).stream()
                .map(VehicleDTO::new).toList();
    }
    
}
