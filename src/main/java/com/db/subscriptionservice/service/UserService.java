package com.db.subscriptionservice.service;

import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.entity.User;
import com.db.subscriptionservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Customer> getCustomersByUser(int userId) {
        return userRepository.findById(userId).get().getCustomers();
    }
}