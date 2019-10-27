package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.service.ChapterService;
import com.dongfan.dongfanapi.untils.PageResult;
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
    public ResponseData getChapterList(@RequestParam(required = true) String name,@RequestParam(required = false,defaultValue = "") Map condition){
        PageResult pageResult =chapterService.getChapterList(name,condition);
        return Response.success(pageResult);
    }

}
