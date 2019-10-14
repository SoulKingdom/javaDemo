package com.example.junittest.design.mode.factory.basic;

import com.example.junittest.design.mode.factory.mode.Americano;
import com.example.junittest.design.mode.factory.mode.Coffee;
import com.example.junittest.design.mode.factory.mode.Latte;

/**
 * 美国咖啡工厂
 * @author Lsj
 *
 */
public class AmericaCoffeeFactory extends CoffeeFactory {

    @Override
    public Coffee[] createCoffee() {
        // TODO Auto-generated method stub
        return new Coffee[]{new Americano(), new Latte()};
    }

}