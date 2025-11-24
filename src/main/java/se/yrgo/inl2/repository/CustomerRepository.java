package se.yrgo.inl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.yrgo.inl2.dto.CustomerVehiclesDTO;
import se.yrgo.inl2.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("""
    SELECT DISTINCT c
    FROM Customer c
    LEFT JOIN FETCH c.vehicles
""")
    List<Customer> findCustomersWithVehicles();

    int findCustomerIdByName(String name);
}
