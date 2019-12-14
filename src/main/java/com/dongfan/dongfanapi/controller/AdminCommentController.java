package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/12/7 22:48
 * @Version 1.0
 */
@RestController
@RequestMapping("admin/comment")
@SysPermission("ADMIN_COMMENT")
public class AdminCommentController {
    @Autowired
    QuestionService questionService;
    @GetMapping("deleteQuestionComment")
    @ApiOperation("管理员删除评论")
    public ResponseData deleteQuestionComment(@RequestParam(required = true,defaultValue = "") String ids){
        List list=Arrays.asList(ids.split(","));
        questionService.deleteQuestionComment(list);
        return Response.success();
    }

    @GetMapping("getCommentList")
    @ApiOperation("获取评论列表")
    public ResponseData getCommentList(@RequestParam(required = false,defaultValue = "-1")int userId,@RequestParam(required = false,defaultValue = "") Map condition){
        condition.put("userId",userId);
        PageResult pageResult=questionService.getTikuCommentList(condition);
        return Response.success(pageResult);
    }
}
