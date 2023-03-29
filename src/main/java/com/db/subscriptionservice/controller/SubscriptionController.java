package com.db.subscriptionservice.controller;

import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/{subscriptionId}/customers")
    public List<Customer> getCustomersBySubscription(@PathVariable(value = "subscriptionId") int subscriptionId) {
        return subscriptionService.getCustomersBySubscription(subscriptionId);
    }
}
