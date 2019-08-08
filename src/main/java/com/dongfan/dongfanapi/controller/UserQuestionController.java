package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    @ApiOperation("获取当前用户章节下的题目列表")
    public ResponseData getQuestionListByChapter(@RequestParam(required = true) int chapterId,@RequestAttribute("userId") int userId,@RequestParam(required = true) String name){
        List list= questionService.getQuestionListByChapter(chapterId,userId,name);
        return Response.success(list);
    }

    @PostMapping("addTikuCollection")
    @ApiOperation("添加题目收藏")
    public ResponseData addTikuCollection(@RequestBody TikuCollection tikuCollection){
        questionService.addTikuCollection(tikuCollection);
        return Response.success();
    }
    @GetMapping("deleteTikuCollection")
    @ApiOperation("删除题目收藏")
    public ResponseData deleteTikuCollection(@RequestParam(required = true) int id){
        questionService.deleteTikuCollection(id);
        return Response.success();
    }
    //当前用户收藏列表
    @GetMapping("getTikuCollectionList")
    @ApiOperation("获取当前用户题目收藏列表")
    public ResponseData getTikuCollectionRecord(){
        List list=new ArrayList();
        return Response.success(list);

    }

//    @GetMapping("getQuestionRecordByChapter")
//    public ResponseData getQuestionRecordByChapter(@RequestParam(required = true) int userId,@RequestParam(required = true) String name){
//        List list= questionService.getQuestionRecordByTikuName(userId,name);
//        return Response.success(list);
//    }
}
