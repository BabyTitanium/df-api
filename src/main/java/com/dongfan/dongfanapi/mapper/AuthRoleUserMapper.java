package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthRoleUser;

public interface AuthRoleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRoleUser record);

    int insertSelective(AuthRoleUser record);

    AuthRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRoleUser record);

    int updateByPrimaryKey(AuthRoleUser record);
}