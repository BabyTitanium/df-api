package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.service.ChapterService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseData getChapterList(@RequestParam String name){
        List list =chapterService.getChapterList(name);
        return Response.success(list);
    }
}
