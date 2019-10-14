package com.example.junittest.design.mode.factory.simple;

import com.example.junittest.design.mode.factory.mode.Americano;
import com.example.junittest.design.mode.factory.mode.Cappuccino;
import com.example.junittest.design.mode.factory.mode.Coffee;
import com.example.junittest.design.mode.factory.mode.Latte;

/**
 * 简单工厂--用于创建不同类型的咖啡实例
 * @author Lsj
 *
 */
public class SimpleFactory {

    /**
     * 通过类型获取Coffee实例对象
     * @param type 咖啡类型
     * @return
     */
    public static Coffee createInstance(String type) {
        if ("americano".equals(type)) {
            return new Americano();
        } else if ("cappuccino".equals(type)) {
            return new Cappuccino();
        } else if ("latte".equals(type)) {
            return new Latte();
        } else {
            throw new RuntimeException("type[" + type + "]类型不可识别，没有匹配到可实例化的对象！");
        }
    }
}