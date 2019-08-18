package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;
import com.dongfan.dongfanapi.mapper.AuthRoleMapper;
import com.dongfan.dongfanapi.mapper.AuthRolePermissionMapper;
import com.dongfan.dongfanapi.service.AuthRoleService;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<AuthRole> getAllRoles(int page,int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return authRoleMapper.getAllRoles(pageStart,pageSize);
    }

    @Override
    public List<AuthPermission> getRolePermissions(int roleId,int page, int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return authRoleMapper.getRolePermissions(roleId,pageStart,pageSize);
    }
}
