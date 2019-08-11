package com.dongfan.dongfanapi.myAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @Author: lll
 * @Date: 2019/8/10 16:31
 * @Version 1.0
 */

@Aspect
@Component
public class TelephoneAspect {
    private Logger logger=LoggerFactory.getLogger(TelephoneAspect.class);
    @Pointcut(value = "@annotation(com.dongfan.dongfanapi.myAnnotation.RequireTelephone)")
    public void annotationPointcut() {
    }


}
