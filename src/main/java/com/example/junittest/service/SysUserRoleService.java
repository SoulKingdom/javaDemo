package com.example.junittest.service;

import com.example.junittest.entity.SysUserRole;

import java.util.List;


public interface SysUserRoleService {

     List<SysUserRole> listByUserId(Integer userId) ;
}
