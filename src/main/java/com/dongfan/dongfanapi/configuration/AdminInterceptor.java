package com.dongfan.dongfanapi.configuration;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lll
 * @Date: 2019/6/20 21:47
 * @Version 1.0
 */

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Subject subject=SecurityUtils.getSubject();
        String role=String.valueOf(subject.getSession().getAttribute("role"));
        if(role.equals("admin")){
            return true;
        }else{
            return false;
        }

    }
}
