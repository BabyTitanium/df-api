package com.dongfan.dongfanapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dongfan.dongfanapi.params.UserLogin;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.*;
import com.dongfan.dongfanapi.entity.User;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/6/29 21:42
 * @Version 1.0
 */

//
//https://open.weixin.qq.com/connect/qrconnect?appid=wx919c848e8e0ea1a0&redirect_uri=http%3A%2F%2Fdfadmin.itwang.wang%2Fuser%2FwebLogin&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect

@Controller
@RequestMapping("user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @Value("${weixin.appId}")
    private String appId;
    @Value("${weixin.secret}")
    private String secret;

    @ApiOperation("用户网页登录")
    @GetMapping("webLogin")
    public String webLogin(@RequestParam(required = true) String code, HttpServletRequest request, HttpServletResponse response) {
        String loginUrl="https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> loginParam = new HashMap<>();
        loginParam.put("appid", appId);
        loginParam.put("secret", secret);
        loginParam.put("code", code);
        loginParam.put("grant_type", "authorization_code");
        String loginResponse = HttpUtils.sendGet(loginUrl, loginParam);
        if(loginResponse==null||loginResponse==""){
            return "登录失败";
        }else{
            JSONObject loginObj = JSON.parseObject(loginResponse);
            if (loginObj.getString("unionid") != null) {
                String unionId = loginObj.getString("unionid");
                User user=userService.getUserByUnionId(unionId);
                if(user==null){
                    String  authUrl="https://api.weixin.qq.com/sns/userinfo";
                    String accessToken=loginObj.getString("access_token");
                    Map<String, String> authParam = new HashMap<>();
                    authParam.put("access_token", accessToken);
                    authParam.put("openid", loginObj.getString("openid"));
                    String userResponse = HttpUtils.sendGet(authUrl, authParam);
                    User insertUser=JSON.parseObject(userResponse,User.class);
                    userService.adduser(insertUser);
                    UserTokenInfo userTokenInfo=new UserTokenInfo();
                    userTokenInfo.setNickName(insertUser.getNickName());
                    userTokenInfo.setUserId(insertUser.getId());
                    String jwt=null;
                    try {
                        jwt=JWTUtils.createJWT(userTokenInfo);
                        response.setHeader("token",jwt);
                    } catch (Exception e) {
                        return "token生成失败";
                    }
                    return "redirect:http://25472238pm.wicp.vip:39967/dfTest/";
                }else{
                    UserTokenInfo userTokenInfo=new UserTokenInfo();
                    userTokenInfo.setNickName(user.getNickName());
                    userTokenInfo.setUserId(user.getId());
                    String jwt=null;
                    try {
                        jwt=JWTUtils.createJWT(userTokenInfo);
                        response.setHeader("token",jwt);
                    } catch (Exception e) {
                        return "token生成失败";
                    }
                    return "redirect:http://25472238pm.wicp.vip:39967/dfTest/";
                }
            }else{
                return "验证失败";
            }
        }
    }

    @ApiOperation("获取个人信息")
    @GetMapping("getUserInfo")
    public ResponseData getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        return Response.success(user);
    }
}
