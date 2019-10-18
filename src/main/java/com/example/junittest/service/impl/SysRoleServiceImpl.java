package com.example.junittest.service.impl;

import com.example.junittest.dao.SysRoleMapper;
import com.example.junittest.entity.SysRole;
import com.example.junittest.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:21
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper roleMapper;

    @Override
    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
