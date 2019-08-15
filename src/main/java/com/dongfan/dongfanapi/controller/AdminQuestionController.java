package com.dongfan.dongfanapi.controller;

import com.dongfan.dongfanapi.myAnnotation.SysPermission;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.Response;
import com.dongfan.dongfanapi.untils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lll
 * @Date: 2019/8/14 22:18
 * @Version 1.0
 */

@RestController
public class AdminQuestionController {
    @Autowired
    QuestionService questionService;
    @SysPermission("QUESTION_DELETE")
    @GetMapping("deleteQuestionComment")
    public ResponseData deleteQuestionComment(@RequestParam int id){
        questionService.deleteQuestionComment(id);
        return Response.success();
    }
}
