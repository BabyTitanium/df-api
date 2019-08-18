package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:44
 * @Version 1.0
 */
public interface AuthRoleService {
    void addRole(AuthRole authRole);

    void deleteRole(int roleId);

    void editRole(AuthRole authRole);

    void addPermissionToRole(AuthRolePermission authRolePermission);

    void removePermissionFromRole(int id);

    List<AuthRole> getAllRoles(int page,int pageSize);

    List<AuthPermission> getRolePermissions(int roleId,int page, int pageSize);
}
