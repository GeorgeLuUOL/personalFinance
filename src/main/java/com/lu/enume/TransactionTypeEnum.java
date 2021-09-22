package com.lu.enume;

public enum TransactionTypeEnum {
    MONEY_IN(0,"转入"),MONEY_OUT(1,"转出"),LOAN_IN(2,"新增贷款"),LOAN_OUT(3,"偿还贷款");

    TransactionTypeEnum(Integer code, String desc) {

    }

    private Integer code;
    private String desc;


    public String getDesc() {
        return desc;
    }


    public Integer getCode() {
        return code;
    }
}
