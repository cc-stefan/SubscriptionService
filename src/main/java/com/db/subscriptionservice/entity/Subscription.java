package com.db.subscriptionservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", unique = true)
    private int subscriptionId;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "speed", nullable = false)
    private Double speed;

    @OneToMany(mappedBy = "subscription")
    @JsonManagedReference(value = "subscription-customers")
    private List<Customer> customers = new ArrayList<>();

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "subscription-bills")
    private List<Bill> bills = new ArrayList<>();

    public Subscription() {
    }

    public Subscription(int subscriptionId, Double cost, String details, String area, Double speed, List<Customer> customers, List<Bill> bills) {
        this.subscriptionId = subscriptionId;
        this.cost = cost;
        this.details = details;
        this.area = area;
        this.speed = speed;
        this.customers = customers;
        this.bills = bills;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
