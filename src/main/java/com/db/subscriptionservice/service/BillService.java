package com.db.subscriptionservice.service;

import com.db.subscriptionservice.entity.Bill;
import com.db.subscriptionservice.entity.Customer;
import com.db.subscriptionservice.entity.Subscription;
import com.db.subscriptionservice.repository.BillRepository;
import com.db.subscriptionservice.repository.CustomerRepository;
import com.db.subscriptionservice.repository.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Bill addBill(int customerId, int subscriptionId, Bill bill) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new EntityNotFoundException("Subscription not found"));

        bill.setCustomer(customer);
        bill.setSubscription(subscription);

        return billRepository.save(bill);
    }

    public List<Bill> searchBillsByTransactionDate(Date dateFrom, Date dateTo) {
        return billRepository.getBillsByTransactionDate(dateFrom, dateTo);
    }
}
