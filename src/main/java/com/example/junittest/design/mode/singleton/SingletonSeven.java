package com.example.junittest.design.mode.singleton;

/**
 *  @dept 上海软件研发中心
 *  @description 懒汉式 线程不安全
 *  @author HaoXin.Liu
 *  @date 2019/9/5 13:29
 **/
public class SingletonSeven {
    private volatile static SingletonSeven instance;

    private SingletonSeven() {
    }

    public static SingletonSeven getInstance() {
        if (null == instance) {
            synchronized (SingletonSeven.class) {
                if (null == instance) {
                    instance = new SingletonSeven();
                }
            }
        }
        return instance;
    }
}