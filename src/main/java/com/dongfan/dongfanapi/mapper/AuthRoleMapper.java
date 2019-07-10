package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthRole;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);
}