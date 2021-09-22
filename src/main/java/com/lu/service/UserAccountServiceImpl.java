package com.lu.service;

import com.lu.mapper.AccountMapper;
import com.lu.pojo.TransactionPO;
import com.lu.pojo.UserAccountPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private Logger logger= LoggerFactory.getLogger(getClass());;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int executeTransaction(TransactionPO transactionPO) {
        Map transactionMap = new HashMap();
        transactionMap.put("amount",transactionPO.getAmount());
        transactionMap.put("userAccountId",transactionPO.getUserAccountId());
        switch (transactionPO.getTransactionType()){
            case LOAN_IN:
                accountMapper.addToLoan(transactionMap);
                break;
            case LOAN_OUT:
                accountMapper.subtractToLoan(transactionMap);
                break;
            case MONEY_IN:
                accountMapper.addToBalance(transactionMap);
                break;
            case MONEY_OUT:
                accountMapper.subtractToBalance(transactionMap);
                break;
            default:
                logger.info("no such case");
        }
        return 1;
    }

    @Override
    public int addAccount(UserAccountPO userAccountPO) {
        accountMapper.addAccount(userAccountPO);
        return 1;
    }
}
