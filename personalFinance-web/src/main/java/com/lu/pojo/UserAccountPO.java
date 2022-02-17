package com.lu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccountPO {

    private Integer userAccountId;

    private String userAccountName;

    private Integer userId;

    private long balance;

    private long loan;

    private Date createDate;
}
