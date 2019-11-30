package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.params.TikuChapterInfo;
import com.dongfan.dongfanapi.service.ChapterService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/10/20 16:22
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/chapter")
@SysPermission("ADMIN_CHAPTER")
public class AdminChapterController {
    @Autowired
    private ChapterService chapterService;
    @PostMapping("addChapter")
    @ApiOperation("添加章节")

    public ResponseData addChapter(@RequestBody @Valid TikuChapterInfo tikuChapterInfo){
        chapterService.addChapter(tikuChapterInfo);
        return Response.success();
    }
    @GetMapping("deleteChapter")
    @ApiOperation("删除章节")
    public ResponseData deleteChapter(@RequestParam (required = true) String name,@RequestParam(required = true,defaultValue = "")String ids){
        List list=Arrays.asList(ids.split(","));
        chapterService.deleteChapter(name,list);
        return Response.success();
    }

}
