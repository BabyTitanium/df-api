package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.UserService;
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
public class AdminUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户列表（可自定义条件，可分页）")
    @GetMapping("getUserList")
    @SysPermission("USER_GETLIST")
    public ResponseData getUserList(@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize) {
            List<User> userList = userService.getUserList(page,pageSize);
            return Response.success(userList);
    }
}
