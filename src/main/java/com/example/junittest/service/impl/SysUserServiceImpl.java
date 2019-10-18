package com.example.junittest.service.impl;

import com.example.junittest.dao.SysUserMapper;
import com.example.junittest.entity.SysUser;
import com.example.junittest.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:17
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}