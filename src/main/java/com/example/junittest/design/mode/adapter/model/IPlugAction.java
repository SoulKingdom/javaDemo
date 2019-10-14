package com.example.junittest.design.mode.adapter.model;

public interface IPlugAction {
    /**
     * 充电动作
     */
    public void charging();
    /**
     * 充电条件
     * 把充电器插到插座上
     */
    public void putChargerToPlug();
}
