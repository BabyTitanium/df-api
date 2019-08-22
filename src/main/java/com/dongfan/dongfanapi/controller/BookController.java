package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.News;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: lll
 * @Date: 2019/8/22 20:18
 * @Version 1.0
 */

@RestController
@RequestMapping("book")
public class BookController {

    @ApiOperation("获取书籍列表")
    @GetMapping("getBookList")
    public ResponseData getBookList(){
        return Response.success();
    }
}
