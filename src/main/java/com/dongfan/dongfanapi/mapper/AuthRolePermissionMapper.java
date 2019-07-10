package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthRolePermission;

public interface AuthRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);
}