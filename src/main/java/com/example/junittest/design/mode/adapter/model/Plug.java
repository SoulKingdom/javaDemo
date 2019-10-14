package com.example.junittest.design.mode.adapter.model;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description 插座类 方法就是可以给使用的设备充电
 *  @author HaoXin.Liu
 *  @date 2019/9/6 11:14
 **/
@Slf4j
public class Plug {
    public void charging(){
        log.info("充电");
    }
}