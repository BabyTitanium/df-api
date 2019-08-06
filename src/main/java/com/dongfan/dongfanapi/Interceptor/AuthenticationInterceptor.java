package com.dongfan.dongfanapi.Interceptor;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.JWTUtils;
import com.dongfan.dongfanapi.untils.UserTokenInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if(request.getRequestURI().contains("Login")){
            return true;
        }
        // 防止 userService 注入不进来
        if (null == userService) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
        }

        String token=request.getHeader("token");
        UserTokenInfo userTokenInfo=JWTUtils.getUserInfo(token);

        // 验证权限
        if (this.hasPermission(userTokenInfo.getUserId(),handler)) {
            return true;
        }
        //  null == request.getHeader("x-requested-with") TODO 暂时用这个来判断是否为ajax请求
        // 如果没有权限 则抛403异常 springboot会处理，跳转到 /error/403 页面
        response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
        return false;
    }

    /**
     * 是否有权限
     */
    private boolean hasPermission(int userId,Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            SysPermission requiredPermission = handlerMethod.getMethod().getAnnotation(SysPermission.class);
            // 如果方法上的注解为空 则获取类的注解
            if (requiredPermission == null) {
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(SysPermission.class);
            }
            // 如果注解为null, 说明不需要拦截, 直接放过
            if (requiredPermission == null) {
                return true;
            }
            // 如果标记了注解，则判断权限
            if (StringUtils.isNotBlank(requiredPermission.value())) {
                // 应该到 redis 或数据库 中获取该用户的权限信息 并判断是否有权限
                //Set<String> permissionSet = userService.getPermissionSet();
                // 这里测试使用 直接add

                List<AuthPermission> permissionList=userService.getUserAuthPermissions(userId);

                if (CollectionUtils.isEmpty(permissionList) ){
                    return false;
                }
                return permissionList.contains(requiredPermission.value());
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
