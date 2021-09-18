package com.lu.enume;

public enum TransactionTypeEnum {
    MONEY_IN(1,"转入"),MONEY_OUT(2,"转出"),LOAN_IN(3,"新增贷款"),LOAN_OUT(4,"偿还贷款");

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
