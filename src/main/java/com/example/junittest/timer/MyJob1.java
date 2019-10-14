package com.example.junittest.timer;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/16 15:09
 **/
@Component
public class MyJob1 {
    public void sayHello() {
        System.out.println("MyJob1>>>"+new Date());
    }
}