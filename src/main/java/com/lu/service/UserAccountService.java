package com.lu.service;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.UserAccountPO;

public interface UserAccountService {

    int executeTransaction(TransactionPO transactionPO);

    int addAccount(UserAccountPO userAccountPO);

}
