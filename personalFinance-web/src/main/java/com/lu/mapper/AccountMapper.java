package com.lu.mapper;

import com.lu.pojo.UserAccountPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface AccountMapper {
    int queryAccountById(int userAccountId);

    int queryAccountByUserId(int userId);

    int addToBalance(Map map);

    int subtractToBalance(Map map);

    int addToLoan(Map map);

    int subtractToLoan(Map map);

    int addAccount(UserAccountPO userAccountPO);
}
