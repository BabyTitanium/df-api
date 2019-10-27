package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.Book;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.BookService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/22 20:17
 * @Version 1.0
 */

@RestController
@RequestMapping("admin/book")
public class AdminBookController {
    @Autowired
    private BookService bookService;
    @ApiOperation("管理员添加书籍")
    @SysPermission("BOOK_ADD")
    @PostMapping("addBook")
    public ResponseData addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return Response.success();
    }
    @ApiOperation("管理员删除书籍")
    @SysPermission("BOOK_DELETE")
    @GetMapping("deleteBook")
    public ResponseData deleteBook(@RequestParam int id){
        bookService.deleteBook(id);
        return Response.success();
    }
    @ApiOperation("管理员修改书籍")
    @SysPermission("BOOK_EDIT")
    @GetMapping("editBook")
    public ResponseData editBook(@RequestBody Book book){
        bookService.updateBook(book);
        return Response.success();
    }
//    @ApiOperation("管理员获取所有的挑错记录")
//    @SysPermission("BOOKERR_LIST")
//    @GetMapping("getAllBookErrList")
//    public ResponseData getAllBookErrList(@RequestParam(required = false,defaultValue = "-1")int page, @RequestParam(required = false,defaultValue = "-1")int pageSize){
//        List<Map> list=bookService.getAllBookErrList(page,pageSize);
//        return Response.success(list);
//    }
    @ApiOperation("管理员审核通过挑错记录")
    @SysPermission("BOOKERR_PASS")
    @PostMapping("bookErrPass")
    public ResponseData bookErrPass(@RequestBody int id){
        bookService.passBookErr(id);
        return Response.success();
    }
    @ApiOperation("管理员审核通过挑错记录")
    @SysPermission("BOOKERR_DISPASS")
    @PostMapping("bookErrDispass")
    public ResponseData bookErrDispass(@RequestBody int id){
        bookService.dispassBookErr(id);
        return Response.success();
    }
}
