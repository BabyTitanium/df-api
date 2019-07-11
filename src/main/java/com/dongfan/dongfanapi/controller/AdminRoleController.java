package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.service.AuthRoleService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:39
 * @Version 1.0
 */
@Controller
@RequestMapping("admin/role")
public class AdminRoleController {
    @Autowired
    private AuthRoleService authRoleService;
    @ApiOperation("给系统添加角色")
    @PostMapping("addRole")
    @RequiresPermissions("ROLE_ADD")
    public ResponseData addAuthRole(@RequestBody AuthRole authRole){
        authRoleService.addRole(authRole);
        return Response.success();
    }

}