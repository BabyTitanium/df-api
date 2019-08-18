package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.NewsType;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.NewsService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/18 17:06
 * @Version 1.0
 */

@RestController
@RequestMapping("admin/news")
public class AdminNewsController {
    @Autowired
    private NewsService newsService;
    @ApiOperation("添加新闻分类")
    @PostMapping("addNewType")
    @SysPermission("NEWSTYPE_ADD")
    public ResponseData addNewType(@Valid @RequestBody NewsType newsType){
        newsService.addNewsType(newsType);
        return Response.success();
    }
    @ApiOperation("删除新闻分类")
    @GetMapping("deleteNewType")
    @SysPermission("NEWSTYPE_DELETE")
    public ResponseData deleteNewType(@RequestParam int id){
        newsService.deleteNewType(id);
        return Response.success();
    }
    @ApiOperation("修改新闻分类")
    @PostMapping("editNewType")
    @SysPermission("NEWSTYPE_EDIT")
    public ResponseData editNewType(@Valid @RequestBody NewsType newsType){
        newsService.editNewsType(newsType);
        return Response.success();
    }
    @ApiOperation("获取新闻分类列表")
    @GetMapping("getNewsTypeList")
    @SysPermission("NEWSTYPE_LIST")
    public ResponseData getNewsTypeList(@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize){
        List list=newsService.getNewsTypeList(page,pageSize);
        return Response.success(list);
    }
    @ApiOperation("获取新闻列表")
    @GetMapping("getNewsList")
    @SysPermission("NEWS_LIST")
    public ResponseData getNewsList(@RequestParam(required = false,defaultValue = "-1")int typeId,@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize){
        List list=newsService.getNewsList(typeId,page,pageSize);
        return Response.success(list);
    }
    @ApiOperation("删除新闻")
    @GetMapping("deleteNews")
    @SysPermission("NEWS_DELETE")
    public ResponseData deleteNews(int id){
        newsService.deleteNews(id);
        return Response.success();
    }
}
