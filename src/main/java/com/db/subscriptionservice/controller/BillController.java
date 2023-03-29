package com.db.subscriptionservice.controller;

import com.db.subscriptionservice.entity.Bill;
import com.db.subscriptionservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping("/new")
    public Bill addBill(@RequestParam int customerId, @RequestParam int subscriptionId, @RequestBody Bill bill) {
        return billService.addBill(customerId, subscriptionId, bill);
    }

    @GetMapping("/search")
    public List<Bill> searchBillsByTransactionDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateFrom,
                                                   @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateTo) {
        return billService.searchBillsByTransactionDate(dateFrom, dateTo);
    }
}
