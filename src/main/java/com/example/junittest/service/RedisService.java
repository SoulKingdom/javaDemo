package com.example.junittest.service;

import com.example.junittest.design.mode.prototype.Person;

/**
 *  @dept 上海软件研发中心
 *  @description 获取Redis值
 *  @author HaoXin.Liu
 *  @date 2019/8/21 17:51
 **/
public interface RedisService {
    /**
      * 获取get值
      *
      * @dept 上海软件研发中心
      * @return String
      * @author HaoXin.Liu
      * @date 2019/9/3 13:12
      **/
    String getValue();
    /**
     * 设置值
     *
     * @dept 上海软件研发中心
     * @return String
     * @author HaoXin.Liu
     * @date 2019/9/3 13:12
     **/
    String setValue(Object obj);

    Integer setPerson();

    Person getPerson();
}
