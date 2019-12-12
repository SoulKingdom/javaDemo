package com.example.junittest.service.impl;

import com.example.junittest.dao.UserDao;
import com.example.junittest.entity.RoleInfo;
import com.example.junittest.entity.UserCond;
import com.example.junittest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/2 14:35
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private Optional<UserDao> userDao;

    @Override
    public Integer countUser() {
        //统计用户数量
        if (userDao.isPresent()) {
            //查询用户数量
            return userDao.get().countUser();
        }
        return 0;
    }

    @Override
    public RoleInfo getUser(UserCond userCond) {
        //根据角色Id获取用户信息
        RoleInfo roleInfo = userDao.get().getUser(userCond);
        return roleInfo;
    }

}