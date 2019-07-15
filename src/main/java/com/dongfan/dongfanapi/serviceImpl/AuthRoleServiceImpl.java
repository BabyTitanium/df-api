package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;
import com.dongfan.dongfanapi.mapper.AuthRoleMapper;
import com.dongfan.dongfanapi.mapper.AuthRolePermissionMapper;
import com.dongfan.dongfanapi.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:44
 * @Version 1.0
 */

@Service
public class AuthRoleServiceImpl implements AuthRoleService {

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Resource
    private AuthRolePermissionMapper authRolePermissionMapper;

    @Override
    public void addRole(AuthRole authRole) {
        authRoleMapper.insertSelective(authRole);
    }

    @Override
    public void deleteRole(int roleId) {
        authRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public void editRole(AuthRole authRole) {
        authRoleMapper.updateByPrimaryKeySelective(authRole);
    }

    @Override
    public void addPermissionToRole(AuthRolePermission authRolePermission) {
        authRolePermissionMapper.insertSelective(authRolePermission);
    }

    @Override
    public void removePermissionFromRole(int id) {
        authRolePermissionMapper.deleteByPrimaryKey(id);
    }
}
