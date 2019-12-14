package com.dongfan.dongfanapi.untils;

/**
 * @Author: lll
 * @Date: 2019/7/1 21:09
 * @Version 1.0
 */
public class Response<T> {
    public static <T> ResponseData success(T t, String message) {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(200);
        responseData.setMessage(message);
        responseData.setData(t);
        return responseData;
    }


    public static <T> ResponseData success(T t) {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(200);
        responseData.setMessage("成功");
        responseData.setData(t);
        return responseData;

    }

    public static <T> ResponseData success() {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(200);
        responseData.setMessage("操作成功");
        responseData.setData(null);
        return responseData;

    }

    public static ResponseData error(String message) {
        ResponseData responseData = new ResponseData<String>();
        responseData.setCode(400);
        responseData.setMessage(message);
        responseData.setData("");
        return responseData;

    }

    public static ResponseData error(String message, int code) {
        ResponseData responseData = new ResponseData<String>();
        responseData.setCode(code);
        responseData.setMessage(message);
        responseData.setData("");
        return responseData;

    }

    public static <T> ResponseData error(String message, T t) {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(400);
        responseData.setMessage(message);
        responseData.setData(t);
        return responseData;

    }
    public static <T> ResponseData noPhone() {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(401);
        responseData.setMessage("telephone is not bind");
        responseData.setData("");
        return responseData;
    }
    public static <T> ResponseData noPermission() {
        ResponseData responseData = new ResponseData<T>();
        responseData.setCode(403);
        responseData.setMessage("no permission");
        responseData.setData("");
        return responseData;

    }
}
