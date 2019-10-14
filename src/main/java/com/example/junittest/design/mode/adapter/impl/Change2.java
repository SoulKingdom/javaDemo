package com.example.junittest.design.mode.adapter.impl;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/6 13:42
 **/
@Slf4j
public class Change2 extends AbstractCharge {
    @Override
    public void putChargerToPlug() {
        log.info("把充电器插到插座上");
    }
}