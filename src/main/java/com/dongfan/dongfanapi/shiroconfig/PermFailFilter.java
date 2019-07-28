package com.dongfan.dongfanapi.shiroconfig;

import com.alibaba.fastjson.JSONObject;
import com.dongfan.dongfanapi.untils.Response;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermFailFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.getWriter().write(JSONObject.toJSON(Response.error("not allowed", 402)).toString());
        return false;
    }
}
