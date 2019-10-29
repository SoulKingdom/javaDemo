package com.example.junittest.service.impl;

import com.example.junittest.service.LambService;

/**
 *  @dept 上海软件研发中心
 *  @description lamb表达式服务
 *  @author HaoXin.Liu
 *  @date 2019/10/25 15:26
 **/
public class LambServiceImpl implements LambService {
    @Override
    public String testLamb(String str1, String str2) {
        StringBuilder sb = new StringBuilder(str1).append(str2);
        return sb.toString();
    }

    public static  String testLambTo(String str1,String str2){
        return "11";
    }
}