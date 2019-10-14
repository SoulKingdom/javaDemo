package com.example.junittest.design.mode.factory.abstractfac;

import com.example.junittest.design.mode.factory.mode.*;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 16:24
 **/
public class AmericaDrinksFactory implements AbstractDrinksFactory {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }

    @Override
    public Tea createTea() {
        return new MilkTea();
    }

    @Override
    public Sodas createSodas() {
        return null;
    }
}