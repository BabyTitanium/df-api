package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.UserLogin;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.PageUtil;
import com.dongfan.dongfanapi.untils.ResponseData;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.untils.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.SSLUtilBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/6/29 21:42
 * @Version 1.0
 */

@RestController
@RequestMapping("user")
public class TestController {
    private  final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @ApiOperation("获取用户列表（可自定义条件，可分页）")
    @GetMapping("getUserList")
    public ResponseData getUserList(@RequestParam Map<String,Object> map ){
        PageUtil.changeToPage(map);
        try {
            List<User> userList=userService.getUserList(map);
            return Response.success(userList);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("查询失败");
        }
    }

    @ApiOperation("用户网页登录")
    @PostMapping("webLogin")
    public ResponseData webLogin(@RequestBody UserLogin userLogin ){
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userLogin.getUsername(),userLogin.getPassword());
        subject.login(usernamePasswordToken);
        return Response.success();
    }
}
