package com.lu.controller;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.User;
import com.lu.service.TransactionService;
import com.lu.service.UserAccountService;
import com.lu.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private Logger logger= LoggerFactory.getLogger(getClass());;
    @Autowired
    TransactionService transactionService;
    @Autowired
    UserAccountService userAccountService;

    @PostMapping(value = "/addTransaction")
    public String addTransaction(@RequestBody TransactionPO transactionPO){
        try{
            userAccountService.executeTransaction(transactionPO);
        }
        catch (Exception e){
            logger.debug("执行事务出错");
            return "transaction failed";
        }
        transactionService.addTransaction(transactionPO);
    return "add transaction completed";
    }

    @GetMapping("/getTransaction")
    public List<TransactionPO> getTransaction(@RequestParam Long userAccountId){
        logger.info("当前用户是{}",SecurityUtils.getUser());
        return transactionService.selectTransactionByAccountId(userAccountId);
    }
}
