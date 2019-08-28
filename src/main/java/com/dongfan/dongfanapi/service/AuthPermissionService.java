package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.AuthPermission;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/18 16:15
 * @Version 1.0
 */

public interface AuthPermissionService {
    List<AuthPermission> getAllPermissions(int page,int pageSize);
    void addPermission(AuthPermission authPermission);
    void deletePermission(int id);
    void editPermission(AuthPermission authPermission);
}
