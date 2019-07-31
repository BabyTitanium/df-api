package com.dongfan.dongfanapi.controller;

import com.alibaba.fastjson.JSON;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.untils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @Author: lll
 * @Date: 2019/7/27 10:27
 * @Version 1.0
 */

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("test1")
    @SysPermission("userAuth")
    public String test1(HttpServletRequest request){
       // String token=request.getHeader("token");
        return "test1 request success!";
    }
    @RequestMapping("test2")
    public String test2(){
        return "test2 request success!";
    }

    @RequestMapping("login")
    public String login(){
        //Session session=SecurityUtils.getSubject().getSession();
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("Houser","Houser");
        subject.login(usernamePasswordToken);

        return "login request success!";
    }
}
