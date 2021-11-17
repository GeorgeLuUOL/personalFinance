package com.lu.mapper;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface TransactionMapper {

    int addTransaction(TransactionPO transactionPO) ;

    List<TransactionPO> selectTransactionByAccountId(@RequestParam("accountId") Long accountId);
}
