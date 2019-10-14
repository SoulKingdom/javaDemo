package com.example.junittest.enume;

import lombok.Data;

public enum ColorEnum {
    RED("红色"), GREEN("绿色"), BLANK("黑色"), YELLOW("黄色");

    private String typeName;

    ColorEnum(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
