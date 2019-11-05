package com.vendor.file.dao;

import com.vendor.file.pojo.UerRoleKey;

public interface UerRoleMapper {
    int deleteByPrimaryKey(UerRoleKey key);

    int insert(UerRoleKey record);

    int insertSelective(UerRoleKey record);
}