package com.dongfan.dongfanapi.Interceptor;

import com.alibaba.fastjson.JSON;
import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.myAnnotation.RequireTelephone;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.JWTUtils;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import com.dongfan.dongfanapi.untils.UserTokenInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/7/29 20:39
 * @Version 1.0
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("**********拦截器被使用");
           String requri=request.getRequestURI();
        if(requri.contains("Login")||requri.contains("swagger")||requri.contains("webjars")||requri.contains("v2")||requri.contains("favicon")){
            return true;
        }
        // 防止 userService 注入不进来
        if (null == userService) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
        }
        Object u=request.getAttribute("userId");
        int userId=Integer.parseInt(String.valueOf(u));
//        User user=userService.getUserById(userId);
//        if(StringUtils.isBlank(user.getPhone())){
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        }
        // 验证权限
        if (this.hasPermission(request,response,handler,userId)) {
            return true;
        }
        //  null == request.getHeader("x-requested-with") TODO 暂时用这个来判断是否为ajax请求
        // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面
      //  response.sendError(response.getStatus(),"无权限");
        return false;
    }

    /**
     * 是否有权限
     */
    private boolean hasPermission(HttpServletRequest request,HttpServletResponse response, Object handler,int userId) throws IOException {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            SysPermission requiredPermission = handlerMethod.getMethod().getAnnotation(SysPermission.class);
            RequireTelephone requireTelephone=handlerMethod.getMethod().getAnnotation(RequireTelephone.class);
            // 如果方法上的注解为空 则获取类的注解
            if (requiredPermission == null) {
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(SysPermission.class);
            }
            if(requireTelephone == null){
                requireTelephone=handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequireTelephone.class);
            }
            // 如果注解为null, 说明不需要拦截, 直接放过
            if (requiredPermission == null&& requireTelephone==null) {
                return true;
            }

            if(requiredPermission!=null){
                // 如果标记了注解，则判断权限
                if (StringUtils.isNotBlank(requiredPermission.value())) {

//                String token=request.getHeader("token");
//                UserTokenInfo userTokenInfo=JWTUtils.getUserInfo(token);

                    List<AuthPermission> permissionList=userService.getUserAuthPermissions(userId);

                    if (CollectionUtils.isEmpty(permissionList) ){
                        return false;
                    }
                    boolean flag=false;
                    for(AuthPermission authPermission:permissionList){
                        if(authPermission.getCode().equalsIgnoreCase(requiredPermission.value())){
                            flag=true;
                        }
                    }
                    if(!flag){
                      //  response.sendError(403,"无权限");
                        ResponseData responseData=Response.noPermission();
                        response.getWriter().write(JSON.toJSONString(responseData));
                        return false;
                    }

                }
            }
            if(requireTelephone!=null){
                if (StringUtils.isNotBlank(requireTelephone.value())) {

                    //List<AuthPermission> permissionList=userService.getUserAuthPermissions(userTokenInfo.getUserId());
                    User user=userService.getUserById(userId);
                    if (StringUtils.isBlank(user.getPhone() )){
                        //response.sendError(401,"未绑定手机号");
                        ResponseData responseData=Response.noPhone();
                        response.getWriter().write(JSON.toJSONString(responseData));
                        return false;
                    }

                }
            }


        }
        return true;
    }


}
