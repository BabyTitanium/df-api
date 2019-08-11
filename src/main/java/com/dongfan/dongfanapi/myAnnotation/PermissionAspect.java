package com.dongfan.dongfanapi.myAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: lll
 * @Date: 2019/7/29 19:53
 * @Version 1.0
 */
@Component
@Aspect
public class PermissionAspect {


    @Pointcut(value = "@annotation(com.dongfan.dongfanapi.myAnnotation.SysPermission)")
    public void annotationPointcut() {
    }



}
