package com.db.subscriptionservice.repository;

import com.db.subscriptionservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "SELECT b.bill_no, b.month, b.cost, b.status, b.customer_id, b.subscription_id, " +
            "t.transaction_id, t.date_of_issue, t.paid_amount, t.payment_method, t.bill_no AS transaction_bill_no " +
            "FROM bills b JOIN transactions t ON b.bill_no = t.bill_no " +
            "WHERE t.date_of_issue BETWEEN :dateFrom AND :dateTo ORDER BY b.bill_no ASC", nativeQuery = true)
    List<Bill> getBillsByTransactionDate(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
