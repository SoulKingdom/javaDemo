package com.example.junittest.service;

import com.example.junittest.entity.RoleInfo;
import com.example.junittest.entity.UserCond;

/**
 *  @dept 上海软件研发中心
 *  @description 用户服务
 *  @author HaoXin.Liu
 *  @date 2019/9/2 14:33
 **/
public interface UserService {

    /**
      * 统计用户数量
      *
      * @dept 上海软件研发中心
      * @return Integer 统计用户数量
      * @author HaoXin.Liu
      * @date 2019/9/2 14:34
      **/
    Integer countUser();

    /**
      * 获取用户信息
      * 
      * @dept 上海软件研发中心
      * @param userCond 用户条件
      * @return
      * @author HaoXin.Liu
      * @date 2019/12/9 15:35
      **/
    RoleInfo getUser(UserCond userCond);
}