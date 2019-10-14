package com.example.junittest.design.mode.singleton;

/**
 *  @dept 上海软件研发中心
 *  @description 饿汉式 不存在线程同步问题
 *  @author HaoXin.Liu
 *  @date 2019/9/5 13:29
 **/
public class SingletonThree {
    private static SingletonThree instance = new SingletonThree();

    private SingletonThree (){}

    public static SingletonThree getInstance() {
    return instance;
    }
}