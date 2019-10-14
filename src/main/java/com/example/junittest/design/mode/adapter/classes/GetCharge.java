package com.example.junittest.design.mode.adapter.classes;

import com.example.junittest.design.mode.adapter.model.IPlugAction;
import com.example.junittest.design.mode.adapter.model.Plug;
import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/6 13:20
 **/
@Slf4j
public class GetCharge extends Plug implements IPlugAction {
    @Override
    public void putChargerToPlug() {
        log.info("把充电器插到插座上");
    }
}