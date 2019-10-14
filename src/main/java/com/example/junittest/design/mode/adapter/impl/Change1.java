package com.example.junittest.design.mode.adapter.impl;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/6 13:41
 **/
@Slf4j
public class Change1 extends AbstractCharge {
    @Override
    public void charging() {
        log.info("充电");
    }
}