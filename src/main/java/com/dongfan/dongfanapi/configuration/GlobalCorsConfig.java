package com.dongfan.dongfanapi.configuration;

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
        String method=request.getMethod();
//        response.setHeader("Access-Control-Allow-Origin", "http://spcc-admin.houserqu.com");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,token");
        response.setHeader("Access-Control-Allow-Credentials","true");

        response.addHeader("Access-Control-Expose-Headers","Content-Type,token");

        System.out.println("*********************************过滤器被使用**************************");

        if(method.equalsIgnoreCase("options")){

            response.setStatus(200);
            return;
        }else{
            chain.doFilter(req, res);
        }

    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
