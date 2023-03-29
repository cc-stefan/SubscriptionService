package com.db.subscriptionservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true)
    private int transactionId;

    @Column(name = "date_of_issue", nullable = false)
    private Date dateOfIssue;

    @Column(name = "paid_amount", nullable = false)
    private Double paidAmount;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_no", nullable = false)
    @JsonBackReference(value = "bill-transactions")
    private Bill bill;

    public Transaction() {
    }

    public Transaction(int transactionId, Date dateOfIssue, Double paidAmount, String paymentMethod, Bill bill) {
        this.transactionId = transactionId;
        this.dateOfIssue = dateOfIssue;
        this.paidAmount = paidAmount;
        this.paymentMethod = paymentMethod;
        this.bill = bill;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
