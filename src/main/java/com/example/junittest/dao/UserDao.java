package com.example.junittest.dao;

import com.example.junittest.entity.RoleInfo;
import com.example.junittest.entity.UserCond;

public interface UserDao {
    /**
     * 统计用户
     *
     * @dept 上海软件研发中心
     * @return 返回用户数量
     * @author HaoXin.Liu
     * @date 2019/9/2 14:53
     **/
    Integer countUser();

    /**
     * 获取用户信息
     *
     * @dept 上海软件研发中心
     * @param userCond 用户条件
     * @return 角色信息
     * @author HaoXin.Liu
     * @date 2019/12/9 15:39
     **/
    RoleInfo getUser(UserCond userCond);
}
