package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.untils.ResponseData;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.untils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lll
 * @Date: 2019/6/29 21:42
 * @Version 1.0
 */

@RestController
public class TestController {
    private  final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;
    @GetMapping("test")
    public ResponseData test(@RequestParam int id){
        int i=0;
        i=i+10;
        logger.info("检查");
        User user =userMapper.selectByPrimaryKey(id);
        return Response.success();
    }
}
