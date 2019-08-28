package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.AuthPermissionService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/18 16:13
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/permission")
public class AdminPermissionController {
    @Autowired
    private AuthPermissionService authPermissionService;
    @ApiOperation("获取所有权限")
    @GetMapping("getAllPermissions")
    @SysPermission("PERMISSION_LIST")
    public ResponseData getAllPermissions(@RequestParam(required = false,defaultValue = "-1")int page, @RequestParam(required = false,defaultValue = "-1")int pageSize){
        List<AuthPermission> list=authPermissionService.getAllPermissions(page,pageSize);
        return Response.success(list);
    }
    @ApiOperation("添加系统权限")
    @PostMapping("addPermission")
    @SysPermission("PERMISSION_ADD")
    public ResponseData addPermission(@Valid @RequestBody AuthPermission authPermission){
        authPermissionService.addPermission(authPermission);
        return Response.success();
    }
    @ApiOperation("删除系统权限")
    @GetMapping("deletePermission")
    @SysPermission("PERMISSION_DELETE")
    public ResponseData deletePermission(@RequestParam int id){
        authPermissionService.deletePermission(id);
        return Response.success();
    }
    @ApiOperation("修改系统权限")
    @PostMapping("editPermission")
    @SysPermission("PERMISSION_EDIT")
    public ResponseData editPermission(@RequestBody AuthPermission authPermission){
        authPermissionService.editPermission(authPermission);
        return Response.success();
    }
}
