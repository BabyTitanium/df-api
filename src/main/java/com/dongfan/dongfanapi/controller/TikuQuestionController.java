package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuComment;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/3 9:56
 * @Version 1.0
 */
@RestController
@RequestMapping("tiku/question")
public class TikuQuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("submitQuestionRecord")
    @ApiOperation("提交用户答题记录")
    public ResponseData submitQuestionRecord(@RequestAttribute("userId") int userId,@RequestBody @Valid TikuRecord tikuRecord){
//        String tikuName=tikuRecord.getTikuName();
//        int questionId=tikuRecord.getQuestionId();
//        Map result=questionService.getQueationById(tikuName,questionId);
        tikuRecord.setUserId(userId);
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
    public ResponseData addTikuCollection(@RequestAttribute("userId") int userId,@RequestBody @Valid TikuCollection tikuCollection){
        tikuCollection.setUserId(userId);
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
    public ResponseData getTikuCollectionRecord(@RequestAttribute("userId") int userId,@RequestParam("name")String name,@RequestParam("page")int page,@RequestParam("pageSize")int pageSize){
        List list=new ArrayList();
        list=questionService.getTikuCollection(userId,name,page,pageSize);
        return Response.success(list);

    }
    @PostMapping("submitQuestionComment")
    @ApiOperation("用户添加题目评论")
    public ResponseData submitQuestionComment(@RequestAttribute("userId") int userId,@RequestBody @Valid TikuComment tikuComment){
        tikuComment.setUserId(userId);
        questionService.addQuestionComment(tikuComment);
        return Response.success();
    }
    @GetMapping("deleteQuestionComment")
    @ApiOperation("用户删除题目评论")
    public ResponseData deleteQuestionComment(@RequestParam int id){
        questionService.deleteQuestionComment(id);
        return Response.success();
    }
//    @PostMapping("addCommentLike")
//    @ApiOperation("点赞评论")
//    public ResponseData addCommentLike(){
//
//        return Response.success();
//    }

}
