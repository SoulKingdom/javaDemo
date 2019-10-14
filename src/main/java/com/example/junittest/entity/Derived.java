package com.example.junittest.entity;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/8/29 17:33
 **/
public class Derived extends Base{

    @Override
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }

    @Override
    public void methodTwo()
    {
        super.methodTwo();
        System.out.print("D");
    }
}