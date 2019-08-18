package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuComment;
import com.dongfan.dongfanapi.entity.TikuRecord;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/8/3 10:25
 * @Version 1.0
 */

public interface QuestionService {
    void addQuestionRecord(TikuRecord tikuRecord);
    List getQuestionListByChapter(int chapterId,int userId, String name,int page,int pageSize);
    void addTikuCollection(TikuCollection tikuCollection);
    void deleteTikuCollection(int id);
    List getTikuCollection(int userId,String name,int page,int pageSize);
    void addQuestionComment(TikuComment tikuComment);
    void deleteQuestionComment(int id);
    void userDeleteQuestionComment(int userId ,int id);
    Map getQueationById(String name, int id);

    List<TikuComment> getTikuCommentList(int userId,String name,int questionId,int page,int pageSize);
//    List getQuestionRecordByTikuName(int chapterId, String name);
}
