package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuRecord;

import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/3 10:25
 * @Version 1.0
 */

public interface QuestionService {
    void addQuestionRecord(TikuRecord tikuRecord);
    List getQuestionListByChapter(int chapterId,int userId, String name);
    void addTikuCollection(TikuCollection tikuCollection);
    void deleteTikuCollection(int id);
//    List getQuestionRecordByTikuName(int chapterId, String name);
}
