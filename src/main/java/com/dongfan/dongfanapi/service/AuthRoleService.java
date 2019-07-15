package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;

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
}
