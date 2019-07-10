package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthPermission;

public interface AuthPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);
}