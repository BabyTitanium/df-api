package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface AuthPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);

    List<AuthPermission> selectUserAuthPermissions(int userId);

    List<AuthPermission> getAllPermissions(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);
}