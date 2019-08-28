package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.Book;
import com.dongfan.dongfanapi.entity.BookErrata;
import com.dongfan.dongfanapi.entity.BookErrataWithBLOBs;
import com.dongfan.dongfanapi.entity.News;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.BookService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/22 20:18
 * @Version 1.0
 */

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @ApiOperation("获取书籍列表")
    @GetMapping("getBookList")
    public ResponseData getBookList(@RequestParam(required = false,defaultValue = "-1")int page, @RequestParam(required = false,defaultValue = "-1")int pageSize){
        List<Book> list=bookService.getBookList(page,pageSize);
        return Response.success(list);
    }
    @ApiOperation("添加错误")
    @PostMapping("addNoSubBookErr")
    public ResponseData addNoSubBookErr(@RequestBody BookErrataWithBLOBs bookErrata){
        bookService.addNoSubBookErr(bookErrata);
        return Response.success();
    }
    @ApiOperation("提交错误")
    @PostMapping("subBookErr")
    public ResponseData subBookErr(@RequestBody BookErrataWithBLOBs bookErrata){
        bookService.subBookErr(bookErrata);
        return Response.success();
    }
    @ApiOperation("删除错误")
    @GetMapping("deleteBookErr")
    public ResponseData deleteBookErr(@RequestAttribute("userId")int userId,@RequestParam int id){
        bookService.deleteBookErr(userId,id);
        return Response.success();
    }
    @ApiOperation("获取自己挑错列表")
    @GetMapping("getUserBookErrList")
    public ResponseData getUserBookErrList(@RequestAttribute("userId")int userId,@RequestParam(required = false,defaultValue = "-1")int page, @RequestParam(required = false,defaultValue = "-1")int pageSize){
        List<Map> list= bookService.getUserBookErrInfo(userId,page,pageSize);
        return Response.success(list);
    }

}
