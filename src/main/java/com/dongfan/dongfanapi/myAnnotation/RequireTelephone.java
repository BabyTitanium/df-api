package com.dongfan.dongfanapi.myAnnotation;

import java.lang.annotation.*;

/**
 * @Author: lll
 * @Date: 2019/8/10 16:30
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireTelephone {
    String value() default "true";
}
