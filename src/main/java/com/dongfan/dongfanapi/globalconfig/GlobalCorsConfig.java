package com.dongfan.dongfanapi.globalconfig;

import com.alibaba.fastjson.JSON;
import com.dongfan.dongfanapi.untils.JWTUtils;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import com.dongfan.dongfanapi.untils.UserTokenInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author: lll
 * @Date: 2019/6/18 11:47
 * @Version 1.0
 */
@Component
public class GlobalCorsConfig implements Filter {

    final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CorsFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String method = request.getMethod();
//        response.setHeader("Access-Control-Allow-Origin", "http://spcc-admin.houserqu.com");

        System.out.println("*********************************过滤器被使用**************************");

        if (method.equalsIgnoreCase("options")) {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,token");
            response.setStatus(200);
            return;
        } else {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,token");
            response.setHeader("Access-Control-Allow-Credentials", "true");

            response.addHeader("Access-Control-Expose-Headers", "Content-Type,token");


            String requri=request.getRequestURI();
            if(requri.contains("Login")||requri.contains("swagger")||requri.contains("webjars")||requri.contains("v2")||requri.contains("favicon")){
                chain.doFilter(req,res);
            }else{
                String token=request.getHeader("token");
                if(token==null){
                    ResponseData responseData=Response.error("invalid token");
                    response.getWriter().write(JSON.toJSONString(responseData));
                    return;
                }else{
                    UserTokenInfo userTokenInfo=JWTUtils.getUserInfo(token);
                    if(userTokenInfo==null){
                        ResponseData responseData=Response.error("invalid token");
                        response.getWriter().write(JSON.toJSONString(responseData));
                        return;
                    }
                    request.setAttribute("userId",userTokenInfo.getUserId());
                }

                chain.doFilter(req, res);
            }

        }

    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
