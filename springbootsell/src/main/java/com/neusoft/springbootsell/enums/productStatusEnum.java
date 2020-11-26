package com.neusoft.springbootsell.enums;

import lombok.Getter;

@Getter
public enum productStatusEnum implements CodeEnum{
    UP(0,"上架"),
    DOWN(1,"下架"),
    ;

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return null;
    }

    productStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
