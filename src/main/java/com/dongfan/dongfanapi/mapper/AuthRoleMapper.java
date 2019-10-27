
package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);

    List<AuthRole> selectUserAuthRoles(int userId);//根据用户ID获取用户角色

    List<AuthRole> getAllRoles(Map map);

    int getAllRolesCount(Map map);

    List<AuthPermission> getRolePermissions(@Param("roleId")int roleId, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
}