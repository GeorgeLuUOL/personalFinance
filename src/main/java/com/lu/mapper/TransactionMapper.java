package com.lu.mapper;

import com.lu.pojo.TransactionPO;
import com.lu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TransactionMapper {

    int addTransaction(TransactionPO transactionPO) ;
}
