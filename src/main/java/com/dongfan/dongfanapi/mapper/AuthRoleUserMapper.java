package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthRoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthRoleUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRoleUser record);

    int insertSelective(AuthRoleUser record);

    AuthRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRoleUser record);

    int updateByPrimaryKey(AuthRoleUser record);


    AuthRoleUser getAuthRoleUser(@Param("userId") int userId, @Param("roleId")int roleId);

    List<Map> getUserRoles(@Param("userId") int id);

    void deleteUserRoles(int userId);
    void addUserRoles(@Param("userId")int userId,@Param("roleIds")List list);

}