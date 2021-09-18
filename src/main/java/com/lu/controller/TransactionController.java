package com.lu.controller;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.User;
import com.lu.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/addTransaction")
    public String addTransaction(@RequestBody TransactionPO transactionPO){
        transactionService.addTransaction(transactionPO);
    return "add transaction completed";
    }
}
