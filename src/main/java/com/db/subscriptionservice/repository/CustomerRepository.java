package com.db.subscriptionservice.repository;

import com.db.subscriptionservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name% ORDER BY c.name ASC")
    List<Customer> searchCustomersByName(@Param("name") String name);
}
