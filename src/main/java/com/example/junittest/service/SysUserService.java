package com.example.junittest.service;

import com.example.junittest.entity.SysUser;
import org.springframework.stereotype.Service;

@Service
public interface SysUserService {

     SysUser selectById(Integer id);

     SysUser selectByName(String name);
}

