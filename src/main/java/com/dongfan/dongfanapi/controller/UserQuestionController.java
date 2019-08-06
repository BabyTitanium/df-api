package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/3 9:56
 * @Version 1.0
 */
@RestController
@RequestMapping("user/question")
public class UserQuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("submitQuestionRecord")
    @ApiOperation("提交用户答题记录")
    public ResponseData submitQuestionRecord(@Valid TikuRecord tikuRecord){
        questionService.addQuestionRecord(tikuRecord);
        return Response.success();
    }
    @GetMapping("getQuestionListByChapter")
    public ResponseData getQuestionListByChapter(@RequestParam(required = true) int chapterId,@RequestParam(required = true) String name){
        List list= questionService.getQuestionListByChapter(chapterId,name);
        return Response.success(list);
    }
    @GetMapping("getQuestionRecordByChapter")
    public ResponseData getQuestionRecordByChapter(@RequestParam(required = true) int userId,@RequestParam(required = true) String name){
        List list= questionService.getQuestionRecordByTikuName(userId,name);
        return Response.success(list);
    }
}
