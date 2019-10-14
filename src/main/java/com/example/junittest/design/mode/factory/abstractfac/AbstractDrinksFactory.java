package com.example.junittest.design.mode.factory.abstractfac;

import com.example.junittest.design.mode.factory.mode.Coffee;
import com.example.junittest.design.mode.factory.mode.Sodas;
import com.example.junittest.design.mode.factory.mode.Tea;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 16:07
 **/
public interface  AbstractDrinksFactory {
    /**
     * 制造咖啡
     * @return
     */
    Coffee createCoffee();

    /**
     * 制造茶
     * @return
     */
    Tea createTea();

    /**
     * 制造碳酸饮料
     * @return
     */
    Sodas createSodas();
}