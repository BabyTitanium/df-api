package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthRolePermission;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

@Mapper
public interface AuthRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);

    AuthRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRolePermission record);

    int updateByPrimaryKey(AuthRolePermission record);
}