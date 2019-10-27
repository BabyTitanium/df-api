package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRolePermission;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.AuthRoleService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:39
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/permission")
@SysPermission("ADMIN_ROLE")
public class AdminRoleController {
    @Autowired
    private AuthRoleService authRoleService;

    @ApiOperation("给系统添加角色")
    @PostMapping("addRole")
    public ResponseData addAuthRole(@RequestBody @Valid AuthRole authRole) {
        authRoleService.addRole(authRole);
        return Response.success();
    }

    @ApiOperation("删除系统角色")
    @GetMapping("deleteRole")
    public ResponseData deleteAuthRole(@RequestParam(required = true) int roleId) {
        authRoleService.deleteRole(roleId);
        return Response.success();
    }

    @ApiOperation("修改系统角色")
    @PostMapping("editRole")
    public ResponseData editAuthRole(@RequestBody @Valid AuthRole authRole) {
        authRoleService.editRole(authRole);
        return Response.success();
    }

    @ApiOperation("给角色添加权限")
    @PostMapping("addPermissionToRole")
    public ResponseData addPermissionToRole(@RequestBody @Valid AuthRolePermission authRolePermission) {
        authRoleService.addPermissionToRole(authRolePermission);
        return Response.success();
    }

    @ApiOperation("给角色移除权限")
    @GetMapping("removePermissionFromRole")
    public ResponseData removePermissionFromRole(@RequestParam(required = true) int id) {
        authRoleService.removePermissionFromRole(id);
        return Response.success();
    }

    @ApiOperation("获取系统所有角色")
    @GetMapping("getAllRoles")
    public ResponseData getAllRoles(@RequestParam(required = false,defaultValue = "") Map condition) {
        PageResult pageResult=authRoleService.getAllRoles(condition);
        return Response.success(pageResult);
    }
    @ApiOperation("获取角色权限")
    @GetMapping("getRolePermissions")
    public ResponseData getRolePermissions(@RequestParam(required = true)int roleId,@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize) {
        List<AuthPermission> list=authRoleService.getRolePermissions(roleId,page,pageSize);
        return Response.success(list);
    }

}
