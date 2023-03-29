package com.db.subscriptionservice.service;

import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Customer> getCustomersBySubscription(int subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).get().getCustomers();
    }
}
