package com.example.junittest.design.mode.singleton;

/**
 *  @dept 上海软件研发中心
 *  @description 饿汉式 内部类实现方式
 *  @author HaoXin.Liu
 *  @date 2019/9/5 13:29
 **/
public class SingletonFive {
    private static class singletonFiveHolder {
        private static final SingletonFive INSTANCE = new SingletonFive();
    }

    private SingletonFive() {
    }

    public static SingletonFive getInstance() {
        return singletonFiveHolder.INSTANCE;
    }
}