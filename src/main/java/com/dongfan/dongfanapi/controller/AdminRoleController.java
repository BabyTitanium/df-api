package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.AuthRoleService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:39
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/role")
public class AdminRoleController {
    @Autowired
    private AuthRoleService authRoleService;

    @ApiOperation("给系统添加角色")
    @PostMapping("addRole")
    @SysPermission("ROLE_ADD")
    public ResponseData addAuthRole(@RequestBody @Valid AuthRole authRole) {
        authRoleService.addRole(authRole);
        return Response.success();
    }

    @ApiOperation("删除系统角色")
    @GetMapping("deleteRole")
    @SysPermission("ROLE_DELETE")
    public ResponseData deleteAuthRole(@RequestParam(required = true) int roleId) {
        authRoleService.deleteRole(roleId);
        return Response.success();
    }

    @ApiOperation("修改系统角色")
    @PostMapping("editRole")
    @SysPermission("ROLE_EDIT")
    public ResponseData editAuthRole(@RequestBody @Valid AuthRole authRole) {
        authRoleService.editRole(authRole);
        return Response.success();
    }

    @ApiOperation("给角色添加权限")
    @PostMapping("addPermissionToRole")
    @SysPermission("ADD_PERMISSION_TO_ROLE")
    public ResponseData addPermissionToRole(@RequestBody @Valid AuthRolePermission authRolePermission) {
        authRoleService.addPermissionToRole(authRolePermission);
        return Response.success();
    }

    @ApiOperation("给角色移除权限")
    @GetMapping("removePermissionFromRole")
    @SysPermission("REMOVE_PERMISSION_FROM_ROLE")
    public ResponseData removePermissionFromRole(@RequestParam(required = true) int id) {
        authRoleService.removePermissionFromRole(id);
        return Response.success();
    }
}
