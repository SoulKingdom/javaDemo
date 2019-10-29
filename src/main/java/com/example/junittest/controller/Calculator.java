package com.example.junittest.controller;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/25 16:37
 **/
public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        //隐式推断类型
        IntegerMath addition = (a, b) -> a + b;
        //显式声明类型
        IntegerMath subtraction = (int a, int b) -> a - b;
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                myApp.operateBinary(20, 10, subtraction));
    }
}