package com.lu.service;

import com.lu.mapper.TransactionMapper;
import com.lu.mapper.UserMapper;
import com.lu.pojo.TransactionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public int addTransaction(TransactionPO transactionPO) {
         transactionMapper.addTransaction(transactionPO);
        return 1;
    }

    @Override
    public List<TransactionPO> selectTransactionByAccountId(Long accountId) {
        return transactionMapper.selectTransactionByAccountId(accountId);
    }

}
