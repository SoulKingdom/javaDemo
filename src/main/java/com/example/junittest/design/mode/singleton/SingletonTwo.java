package com.example.junittest.design.mode.singleton;

/**
 *  @dept 上海软件研发中心
 *  @description 懒汉式 线程安全
 *  @author HaoXin.Liu
 *  @date 2019/9/5 13:29
 **/
public class SingletonTwo {
    private static SingletonTwo instance;

    private SingletonTwo() {
    }

    public static synchronized SingletonTwo getInstance(){
        if(null == instance){
            instance = new SingletonTwo();
        }
        return instance;
    }
}