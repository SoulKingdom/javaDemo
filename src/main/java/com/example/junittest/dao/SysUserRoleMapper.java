package com.example.junittest.dao;

import com.example.junittest.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:16
 **/
@Mapper
public interface SysUserRoleMapper {
    @Select({"SELECT * FROM sys_user_role WHERE user_id = #{userId}"})
    List<SysUserRole> listByUserId(Integer userId);
}
