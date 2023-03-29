package com.db.subscriptionservice.controller;

import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public List<Customer> searchCustomersByName(@RequestParam(value = "name") String name) {
        return customerService.searchCustomersByName(name);
    }
}
