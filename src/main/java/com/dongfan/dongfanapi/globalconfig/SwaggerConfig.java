package com.dongfan.dongfanapi.globalconfig;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/15 21:39
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Bean
//    public Docket swaggerSpringMvcPlugin() {
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
//    }
    @Bean
    public Docket createRestApi() {
        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJuaWNrTmFtZVwiOlwi5YiY6Lmm5ZOSXHVEODNEXHVEQzhCXCIsXCJ1c2VySWRcIjoyMH0iLCJleHAiOjE1Njg2MjUwMzB9.mEt08TYnLMLo17ckW9UfVwAxpRwt4U9kEcXQxMjnjnI").build();
        pars.add(tokenPar.build());
        //添加head参数配置end
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dongfan.dongfanapi"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);//注意这里
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("束手就擒--简单优雅的restfun风格")
                .termsOfServiceUrl("https://blog.csdn.net/ssjq123")
                .version("1.0")
                .build();
    }

}
