package com.example.junittest.design.mode.factory.basic;

import com.example.junittest.design.mode.factory.mode.Coffee;
import lombok.Data;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 15:47
 **/
@Data
public abstract class CoffeeFactory {
    /**
     * 生产可制造的咖啡
     * @return
     */
    public abstract Coffee[] createCoffee();
}