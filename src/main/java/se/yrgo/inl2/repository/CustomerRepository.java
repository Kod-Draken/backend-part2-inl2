package se.yrgo.inl2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.yrgo.inl2.dto.CustomerIdNameDTO;
import se.yrgo.inl2.dto.CustomerVehiclesDTO;
import se.yrgo.inl2.entity.Customer;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("""
    SELECT DISTINCT c
    FROM Customer c
    LEFT JOIN FETCH c.vehicles
    """)
    List<Customer> findCustomersWithVehicles();

    @Query("""
    SELECT c.id, c.name
    FROM Customer c
    WHERE c.name LIKE %:name%
    """)
    List<CustomerIdNameDTO> findCustomerIdByName(@Param("name") String name);

    Customer findCustomerById(int customerId);
}
