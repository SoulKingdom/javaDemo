package com.example.junittest.design.mode.bridge;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/9 15:30
 **/
public class Abstraction {
    Implementor impl;

    public Abstraction(Implementor impl) {
        this.impl = impl;
    }

    //示例方法
    public void operation() {
        impl.operationImpl();
    }
}