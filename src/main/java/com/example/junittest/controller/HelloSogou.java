package com.example.junittest.controller;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/8/30 14:10
 **/
public class HelloSogou {
    public static void main(String[] args) {
        synchronized (HelloSogou.class) {
            Thread thread = new Thread(() -> Sogou());
            thread.start();
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void Sogou() {
        synchronized (TestController.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println("Sogou");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}