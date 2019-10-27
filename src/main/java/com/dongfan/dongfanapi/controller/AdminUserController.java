package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:38
 * @Version 1.0
 */
@Controller
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
}
