package com.example.junittest.design.mode.bridge;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/9 15:46
 **/
@Slf4j
public class ImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        log.info("实现方式2");
    }
}