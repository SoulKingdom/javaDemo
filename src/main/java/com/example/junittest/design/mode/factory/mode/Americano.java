package com.example.junittest.design.mode.factory.mode;

import lombok.Data;

/**
 * 美式咖啡
 * @author Lsj
 *
 */
@Data
public class Americano extends Coffee {

    @Override
    public String getName() {
        return "美式咖啡";
    }

}