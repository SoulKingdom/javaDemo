package com.example.junittest.service.impl;

import com.example.junittest.constant.ConverConstants;
import com.example.junittest.constant.UnitConstant;
import com.example.junittest.service.UnitConver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description 电能单位转换
 *  @author HaoXin.Liu
 *  @date 2019/8/29 13:32
 **/
public class ElectricEnergyUnitConver implements UnitConver {
    /**
     * W单位转换 最多到GW
     *
     * @dept 上海软件研发中心
     * @param value 值
     * @param unit 单位
     * @return List<String> 存储单位和值
     * @author HaoXin.Liu
     * @date 2019/8/29 13:34
     **/
    @Override
    public List<String> getValueAndUnitMap(String value, String unit) {
        //封装单位、值和转换次数
        List<String> unitList = new ArrayList<>(2);
        //获取转换单位的数值
        BigDecimal valueTo = new BigDecimal(value);
        //单位转换进制
        BigDecimal converValue = new BigDecimal(ConverConstants.UNIT_CONVER_THOUSAND);
        //回归基础单位
        if (UnitConstant.KW.equals(unit)) {
            valueTo = valueTo.multiply(converValue.pow(1));
        }
        if (UnitConstant.MW.equals(unit)) {
            valueTo = valueTo.multiply(converValue.pow(2));
        }
        //需要转换单位类型
        int type = 0;
        for (; type < 3 && valueTo.compareTo(converValue) >= 0; type++) {
            valueTo = valueTo.divide(converValue);
        }
        //判断转化的单位
        if (type == 1) {
            unit = UnitConstant.KW;
        } else if (type == 2) {
            unit = UnitConstant.MW;
        }
        //封装单位和值 次数
        unitList.add(valueTo.toString());
        unitList.add(unit);
        return unitList;
    }


}