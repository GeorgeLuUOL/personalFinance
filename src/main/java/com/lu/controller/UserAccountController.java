package com.lu.controller;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.UserAccountPO;
import com.lu.service.TransactionService;
import com.lu.service.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class UserAccountController {
    private Logger logger= LoggerFactory.getLogger(getClass());;
    @Autowired
    TransactionService transactionService;
    @Autowired
    UserAccountService userAccountService;

    @PostMapping(value = "/addUserAccount")
    public String addUserAccount(@RequestBody UserAccountPO userAccountPO){
        userAccountService.addAccount(userAccountPO);
//        try{
//            userAccountService.addAccount(userAccountPO);
//        }
//        catch (Exception e){
//            logger.debug("添加用户账户出错");
//            return "adding failed";
//        }
       return "添加成功";
    }
}
