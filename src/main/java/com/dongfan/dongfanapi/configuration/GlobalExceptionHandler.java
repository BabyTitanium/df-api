package com.dongfan.dongfanapi.configuration;

import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData allHandler(HttpServletRequest req, Exception e) throws Exception {
        return Response.error("未知错误",e.getMessage());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseData paramValidateHandler(HttpServletRequest req, Exception e) throws Exception {
            return Response.error("参数异常");
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, TypeMismatchException.class})
    @ResponseBody
    public ResponseData paramErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println(e.getClass());

        return Response.error("参数错误", e.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResponseData requestErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        System.out.println(e.getClass());

        return Response.error("请求错误", e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseData defaultExceptionHandler(HttpServletRequest req,Exception e){
        return Response.error("not allowed", 402);
    }


}