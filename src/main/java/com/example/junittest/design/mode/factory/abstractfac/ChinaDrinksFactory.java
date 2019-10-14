package com.example.junittest.design.mode.factory.abstractfac;

import com.example.junittest.design.mode.factory.mode.*;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 16:23
 **/
public class ChinaDrinksFactory implements AbstractDrinksFactory {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }

    @Override
    public Tea createTea() {
        return null;
    }

    @Override
    public Sodas createSodas() {
        return new CocaCola();
    }
}