package com.example.junittest.service.impl;

import com.example.junittest.dao.UserDao;
import com.example.junittest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/2 14:35
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public Integer countUser() {
        return userDao.countUser();
    }
}