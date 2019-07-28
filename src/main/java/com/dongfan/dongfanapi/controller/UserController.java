package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.params.UserLogin;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.JWTUtils;
import com.dongfan.dongfanapi.untils.ResponseData;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.UserTokenInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lll
 * @Date: 2019/6/29 21:42
 * @Version 1.0
 */

@RestController
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @ApiOperation("用户网页登录")
    @PostMapping("webLogin")
    public ResponseData webLogin(@RequestBody UserLogin userLogin) {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userLogin.getUsername(), userLogin.getPassword());
//        subject.login(usernamePasswordToken);
//        User user = userService.getUserByNickname(userLogin.getUsername());
//        subject.getSession().setAttribute("user", user);
        logger.info(userLogin.getUsername() + "登录成功");
        UserTokenInfo userTokenInfo=new UserTokenInfo();
        userTokenInfo.setNickName("Houser");
        userTokenInfo.setUserId(1);
        String jwt=null;
        try {
             jwt=JWTUtils.createJWT(userTokenInfo);
        } catch (Exception e) {
           return Response.error("token生成失败");
        }
        return Response.success(jwt);
    }

    @ApiOperation("获取个人信息")
    @GetMapping("getUserInfo")
    public ResponseData getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        return Response.success(user);
    }
}
