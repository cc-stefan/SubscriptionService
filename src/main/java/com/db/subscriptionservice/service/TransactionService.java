package com.db.subscriptionservice.service;

import com.db.subscriptionservice.entity.Transaction;
import com.db.subscriptionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByPaymentMethod(String paymentMethod) {
        return transactionRepository.getTransactionsByPaymentMethod(paymentMethod);
    }
}
