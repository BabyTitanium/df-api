package com.dongfan.dongfanapi.globalconfig;

import com.dongfan.dongfanapi.Interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: lll
 * @Date: 2019/7/29 20:43
 * @Version 1.0
 */

@Configuration
public class InterceptorConfig  extends WebMvcConfigurationSupport {
    /*
     * 拦截器配置
     * 在spring-mvc.xml配置文件内添加<mvc:interceptor>标签配置拦截器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 权限校验拦截器配置
        registry.addInterceptor(securityInterceptor()).addPathPatterns("/**");

        // 父类的配置
        super.addInterceptors(registry);
    }
    @Bean
    public AuthenticationInterceptor securityInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
