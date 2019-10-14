package com.example.junittest.util;

import com.example.junittest.service.UnitConver;
import com.example.junittest.service.impl.ElectricEnergyUnitConver;

/**
 *  @dept 上海软件研发中心
 *  @description 单位转换工厂
 *  @author HaoXin.Liu
 *  @date 2019/8/29 14:18
 **/
public class UnitConverFactory {
    /**
      * 提供电功率单位转换
      *
      * @dept 上海软件研发中心
      * @return
      * @author HaoXin.Liu
      * @date 2019/8/29 14:20
      **/
    public static UnitConver produceElectricEnergy() {
        return new ElectricEnergyUnitConver();
    }

}