package com.example.junittest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *  @dept 上海软件研发中心
 *  @description 用户角色
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:13
 **/
@Data
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

    // 省略getter/setter
}
