package com.dongfan.dongfanapi.untils;

import lombok.Data;

/**
 * @Author: lll
 * @Date: 2019/7/1 21:12
 * @Version 1.0
 */
@Data
public class ResponseData<T> {
    int code;
    T data;
    String message;
}
