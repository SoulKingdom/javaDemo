package com.example.junittest.service.impl;

import com.example.junittest.dao.SysRoleMapper;
import com.example.junittest.entity.SysRole;
import com.example.junittest.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:21
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    /*    @Resource
        private SysRoleMapper roleMapper;*/
    @Resource
    Optional<SysRoleMapper> roleMapper;

    /**
     * 根据用户id查找用户信息
     *
     * @dept 上海软件研发中心
     * @param id 用户id
     * @return SysRole 用户角色信息
     * @author HaoXin.Liu
     * @date 2019/11/18 11:01
     **/
    @Override
    public SysRole selectById(Integer id) {
        //判断是否自动注入数据
        if (roleMapper.isPresent()) {
            return roleMapper.get().selectById(id);
        } else {
            return new SysRole();
        }
        //return roleMapper.selectById(id);
    }
}
