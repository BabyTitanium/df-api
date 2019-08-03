package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.entity.TikuXiyiQuestion;
import com.dongfan.dongfanapi.mapper.*;
import com.dongfan.dongfanapi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/3 10:25
 * @Version 1.0
 */

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private TikuRecordMapper tikuRecordMapper;
    @Resource
    private TikuXiyiQuestionMapper tikuXiyiQuestionMapper;
    @Resource
    private TikuKouqiangQuestionMapper tikuKouqiangQuestionMapper;
    @Resource
    private TikuXiyizhiyeQuestionMapper tikuXiyizhiyeQuestionMapper;
    @Resource
    private TikuZhiyexiyaoshiQuestionMapper tikuZhiyexiyaoshiQuestionMapper;
    @Resource
    private TikuZhiyezhongyaoshiQuestionMapper tikuZhiyezhongyaoshiQuestionMapper;
    @Resource
    private TikuZhongyizhiyeChapterMapper tikuZhongyizhiyeChapterMapper;
    @Override
    public void addQuestionRecord(TikuRecord tikuRecord) {
        tikuRecordMapper.insertSelective(tikuRecord);
    }

    @Override
    public List getQuestionListByChapter(int chapterId, String name) {
        List<Object> list=new ArrayList();
        if(name.equals("xiyizhiye")){
            list=tikuXiyizhiyeQuestionMapper.getListByChapterId(chapterId);
        }
        return list;
    }
}
