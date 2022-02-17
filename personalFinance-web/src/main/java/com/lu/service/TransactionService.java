package com.lu.service;

import com.lu.pojo.TransactionPO;

import java.util.List;

public interface TransactionService {

    int addTransaction(TransactionPO transactionPO);

    List<TransactionPO> selectTransactionByAccountId(Long accountId);
}
