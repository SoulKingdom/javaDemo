package com.example.junittest.design.mode.factory.basic;

import com.example.junittest.design.mode.factory.mode.Cappuccino;
import com.example.junittest.design.mode.factory.mode.Coffee;
import com.example.junittest.design.mode.factory.mode.Latte;

/**
 * 中国咖啡工厂
 * @author Lsj
 *
 */
public class ChinaCoffeeFactory extends CoffeeFactory {

    @Override
    public Coffee[] createCoffee() {
        // TODO Auto-generated method stub
        return new Coffee[]{new Cappuccino(), new Latte()};
    }

}