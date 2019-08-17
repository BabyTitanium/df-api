package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuComment;
import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.entity.TikuXiyiQuestion;
import com.dongfan.dongfanapi.mapper.*;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TikuCommentMapper tikuCommentMapper;
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
    private TikuZhongyizhiyeQuestionMapper tikuZhongyizhiyeQuestionMapper;
    @Resource
    private TikuCollectionMapper tikuCollectionMapper;
    @Override
    public void addQuestionRecord(TikuRecord tikuRecord) {
        tikuRecordMapper.insertSelective(tikuRecord);
    }
//  xiyi     kouqiang     xiyizhiye    zhiyexiyaoshi    zhiyezhongyaoshi    zhongyizhiye

    @Override
    public List getQuestionListByChapter(int chapterId,int userId, String name,int page,int pageSize) {
        String dataname="tiku_"+name+"_question";
        List<Map> list=new ArrayList();
        Map<String,Object> map=new HashMap<>();
        int pageStart=PageUtil.getStart(page,pageSize);
        list=tikuRecordMapper.getQuestionList(chapterId,userId,name,dataname,pageStart,pageSize);
        return list;
    }

    @Override
    public void addTikuCollection(TikuCollection tikuCollection) {
        tikuCollectionMapper.insertSelective(tikuCollection);
    }

    @Override
    public void deleteTikuCollection(int id) {
        tikuCollectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List getTikuCollection(int userId, String name,int page,int pageSize) {
        String dataneme="tiku_"+name+"_question";
        int pageStart=PageUtil.getStart(page,pageSize);
        return tikuCollectionMapper.getTikuCollection(dataneme,name,userId,pageStart,pageSize);
    }

    @Override
    public void addQuestionComment(TikuComment tikuComment) {
        tikuCommentMapper.insertSelective(tikuComment);
    }
    @Override
    public void userDeleteQuestionComment(int userId ,int id) {
        tikuCommentMapper.deleteByUserAndId(userId,id);
    }
    @Override
    public void deleteQuestionComment(int id) {
        tikuCommentMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Map getQueationById(String name, int id) {
        String dataname="tiku_"+name+"_queation";
        return    tikuRecordMapper.getTikuQuestionById(dataname,id);
    }

    @Override
    public List<TikuComment> getTikuCommentList(String name, int questionId) {
        return tikuCommentMapper.getTikuCommentList(name,questionId);
    }

//    @Override
//    public List getQuestionRecordByTikuName(int userId, String name) {
//        List<Object> list=new ArrayList();
//        if(name.equals("xiyizhiye")){
//            list=tikuRecordMapper.getXiyizhiyeRecord(userId);
//        }else if(name.equals("xiyi")){
//            list=tikuRecordMapper.getXiyiRecord(userId);
//        }else if(name.equals("kouqiang")){
//            list=tikuRecordMapper.getKouqiangRecord(userId);
//        }else if(name.equals("zhiyexiyaoshi")){
//            list=tikuRecordMapper.getZhiyexiyaoshiRecord(userId);
//        }else if(name.equals("zhiyezhongyaoshi")){
//            list=tikuRecordMapper.getZhiyezhongyaoshiRecord(userId);
//        }else if(name.equals("zhongyizhiye")) {
//            list = tikuRecordMapper.getZhongyizhiyeRecord(userId);
//        }
//        return list;
//    }
}
