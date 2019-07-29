package com.dongfan.dongfanapi.myAnnotation;

import java.lang.annotation.*;

/**
 * @Author: lll
 * @Date: 2019/7/29 19:35
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysPermission {
    String value() default "";
}
