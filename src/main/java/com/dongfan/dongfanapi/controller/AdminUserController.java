package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.AuthRoleUser;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.params.UserRole;
import com.dongfan.dongfanapi.params.UserRoles;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.PageUtil;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:38
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/user")
@SysPermission("ADMIN_USER")
public class AdminUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户列表（可自定义条件，可分页）")
    @GetMapping("getUserList")
    public ResponseData getUserList(@RequestParam(required = false,defaultValue = "") Map condition) {
            PageResult pageResult = userService.getUserList(condition);
            return Response.success(pageResult);
    }
    @ApiOperation("添加用户角色")
    @PostMapping("addUserRole")
    public ResponseData addUserRole(@RequestBody UserRole userRole) {
        AuthRoleUser authRoleUser=new AuthRoleUser();
        authRoleUser.setUserId(userRole.getUser_id());
        authRoleUser.setRoleId(userRole.getRole_id());
        userService.addUserRole(authRoleUser);
        return Response.success();
    }
    @ApiOperation("删除用户角色")
    @GetMapping("deleteUserRole")
    public ResponseData deleteUserRole(@RequestParam int id) {
        userService.deleteUserRole(id);
        return Response.success();
    }

    @ApiOperation("获取用户角色")
    @GetMapping("getUserRoles")
    public ResponseData getUserRoles(@RequestParam int id) {
        List list=userService.getUserRoles(id);
        return Response.success(list);
    }
    @ApiOperation("添加多个角色")
    @PostMapping("addRolesToUser")
    public ResponseData addRolesToUser(@RequestBody @Valid UserRoles userRoles) {
        userService.deleteUserRoles(userRoles.getUserId());
        userService.addUserRoles(userRoles);
        return Response.success();
    }
}
