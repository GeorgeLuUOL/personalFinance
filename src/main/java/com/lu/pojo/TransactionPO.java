package com.lu.pojo;

import com.lu.enume.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionPO {
    private Integer transactionId;

    private Integer userAccountId;

    private TransactionTypeEnum transactionType;

    private long amount;

    private Timestamp transactionTime;

}
