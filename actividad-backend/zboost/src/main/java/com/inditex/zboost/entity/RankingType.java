package com.inditex.zboost.entity;

import java.util.Arrays;

public enum RankingType {

    ORDERS("orders"), UNITS("units"), AMOUNT("amount");

    private String type;

    RankingType(String type) {
        this.type = type;
    }

    public static RankingType fromType(String type) {
        return Arrays.stream(RankingType.values()).filter(r -> r.type.equals(type)).findFirst().get();
    }

}
