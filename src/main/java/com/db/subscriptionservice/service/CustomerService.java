package com.db.subscriptionservice.service;

import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.searchCustomersByName(name);
    }
}
