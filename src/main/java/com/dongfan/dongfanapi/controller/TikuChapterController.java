package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.service.ChapterService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/10 18:19
 * @Version 1.0
 */
@RestController
@RequestMapping("tiku/chapter")
public class TikuChapterController {
    @Autowired
    private ChapterService chapterService;
    @GetMapping("getChapterList")
    @ApiOperation("根据题库名称获取章节列表")
    public ResponseData getChapterList(@RequestParam String name,@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize){
        List list =chapterService.getChapterList(name,page,pageSize);
        return Response.success(list);
    }

    @PostMapping("addChapter")
    @ApiOperation("添加章节")
    public ResponseData addChapter(){
        return Response.success();
    }
}
