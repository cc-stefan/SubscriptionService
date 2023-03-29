package com.db.subscriptionservice.controller;

import com.db.subscriptionservice.entity.Transaction;
import com.db.subscriptionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/search")
    public List<Transaction> getTransactionsByPaymentMethod(@RequestParam(value = "paymentMethod") String paymentMethod) {
        return transactionService.getTransactionsByPaymentMethod(paymentMethod);
    }
}
