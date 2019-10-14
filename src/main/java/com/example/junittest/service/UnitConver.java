package com.example.junittest.service;

import java.util.List;
import java.util.Map;

/**
 * 单位转换接口
 *
 * @dept 上海软件研发中心
 * @author HaoXin.Liu
 * @date 2019/8/29 11:34
 **/
public interface UnitConver {

    /**
     * 单位和值进行转换
     *
     * @dept 上海软件研发中心
     * @param value 需要转换的值
     * @param unit 需要转换的单位
     * @return List 单位和值封装到List中 0 值 1单位
     * @author HaoXin.Liu
     * @date 2019/8/29 13:20
     **/
    List<String> getValueAndUnitMap(String value, String unit);
}

