package com.db.subscriptionservice.repository;

import com.db.subscriptionservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE t.paymentMethod = :paymentMethod")
    List<Transaction> getTransactionsByPaymentMethod(@Param("paymentMethod") String paymentMethod);
}
