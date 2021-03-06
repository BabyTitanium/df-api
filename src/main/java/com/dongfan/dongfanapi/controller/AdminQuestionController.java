package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.params.TikuQuestionInfo;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/14 22:18
 * @Version 1.0
 */

@RestController
@RequestMapping("admin/question")
@SysPermission("ADMIN_QUESTION")
public class AdminQuestionController {
    @Autowired
    QuestionService questionService;


    @GetMapping("getQuestionList")
    @ApiOperation("获取题目列表")
    public ResponseData getQuestionList( @RequestParam(required = true) String name, @RequestParam(required = false,defaultValue = "") Map condition){
        PageResult pageResult= questionService.getAllQuestionList(name,condition);
        return Response.success(pageResult);
    }

    @GetMapping("deleteQuestion")
    @ApiOperation("删除题目")
    public ResponseData deleteQuestion( @RequestParam(required = true) String name, @RequestParam(required = true,defaultValue = "") String ids){
        List list=Arrays.asList(ids.split(","));
        questionService.deleteQuestion(name,list);
        return Response.success();
    }

    @PostMapping("addQuestion")
    @ApiOperation("添加题目")
    public ResponseData addQuestion(@Valid @RequestBody TikuQuestionInfo tikuQuestionInfo){
        questionService.addQuestion(tikuQuestionInfo);
        return Response.success();
    }

    @PostMapping("editQuestion")
    @ApiOperation("添加题目")
    public ResponseData editQuestion(@Valid @RequestBody TikuQuestionInfo tikuQuestionInfo){
        questionService.editQuestion(tikuQuestionInfo);
        return Response.success();
    }
    @GetMapping("getQuestion")
    @ApiOperation("获取题目")
    public ResponseData getQuestion(@RequestParam(required = true) String name,@RequestParam(required = true) int id){
        Map map=questionService.getQueationById(name,id);
        return Response.success(map);
    }
}
