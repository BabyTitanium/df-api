package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.entity.TikuComment;
import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/14 22:18
 * @Version 1.0
 */

@RestController
public class AdminQuestionController {
    @Autowired
    QuestionService questionService;
    @SysPermission("COMMENT_DELETE")
    @GetMapping("deleteQuestionComment")
    @ApiOperation("管理员删除评论")
    public ResponseData deleteQuestionComment(@RequestParam int id){
        questionService.deleteQuestionComment(id);
        return Response.success();
    }
    @SysPermission("COMMENT_LIST")
    @GetMapping("getCommentList")
    @ApiOperation("获取评论列表")
    public ResponseData getCommentList(@RequestParam(required = false,defaultValue = "-1")int userId,@RequestParam(required = false,defaultValue = "") String name,@RequestParam(required = false,defaultValue = "-1") int questionId,@RequestParam(required = false,defaultValue = "-1")int page,@RequestParam(required = false,defaultValue = "-1")int pageSize){
        List<TikuComment> list=questionService.getTikuCommentList(userId,name,questionId,page,pageSize);
        return Response.success(list);
    }

}
