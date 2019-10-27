package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.untils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/18 16:15
 * @Version 1.0
 */

public interface AuthPermissionService {
    PageResult getAllPermissions(Map map);
    void addPermission(AuthPermission authPermission);
    void deletePermission(int id);
    void editPermission(AuthPermission authPermission);
}
