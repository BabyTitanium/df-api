package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuComment;
import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.params.TikuQuestionInfo;
import com.dongfan.dongfanapi.untils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/3 10:25
 * @Version 1.0
 */

public interface QuestionService {
    void addQuestionRecord(TikuRecord tikuRecord);
    PageResult getQuestionListByChapter(int userId, String name,Map map);
    void addTikuCollection(TikuCollection tikuCollection);
    void deleteTikuCollection(int id);
    PageResult getTikuCollection(String name, Map map);
    void addQuestionComment(TikuComment tikuComment);
    void deleteQuestionComment(int id);
    void userDeleteQuestionComment(int userId ,int id);
    Map getQueationById(String name, int id);

    PageResult getTikuCommentList(Map map);
    PageResult getAllQuestionList(String name,Map map);
    void deleteQuestion(String name,List ids);
    void addQuestion(TikuQuestionInfo tikuInfo);
    void editQuestion(TikuQuestionInfo tikuInfo);
//    List getQuestionRecordByTikuName(int chapterId, String name);
}
