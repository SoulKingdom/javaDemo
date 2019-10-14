package com.example.junittest.design.mode.adapter.obj;

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
public class GetChargeTo implements IPlugAction {
    private Plug plug;

    public GetChargeTo(Plug plug) {
        this.plug = plug;
    }

    @Override
    public void charging() {
        plug.charging();
    }

    @Override
    public void putChargerToPlug() {
        log.info("把充电器插到插座上");
    }
}