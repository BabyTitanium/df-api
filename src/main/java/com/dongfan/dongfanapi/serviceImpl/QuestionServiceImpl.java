package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.entity.TikuXiyiQuestion;
import com.dongfan.dongfanapi.mapper.*;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.PageUtil;
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
    public List getQuestionListByChapter(int chapterId,int userId, String name) {
        String dataname="tiku_"+name+"_question";
        List<Map> list=new ArrayList();
        list=tikuRecordMapper.getQuestionList(chapterId,userId,name,dataname);
//        if(name.equals("xiyizhiye")){
//            list=tikuXiyizhiyeQuestionMapper.getListByChapterId(chapterId);
//        }else if(name.equals("xiyi")){
//            list=tikuXiyiQuestionMapper.getListByChapterId(chapterId,userId);
//        }else if(name.equals("kouqiang")){
//            list=tikuKouqiangQuestionMapper.getListByChapterId(chapterId);
//        }else if(name.equals("zhiyexiyaoshi")){
//            list=tikuZhiyexiyaoshiQuestionMapper.getListByChapterId(chapterId);
//        }else if(name.equals("zhiyezhongyaoshi")){
//            list=tikuZhiyezhongyaoshiQuestionMapper.getListByChapterId(chapterId);
//        }else if(name.equals("zhongyizhiye")) {
//            list = tikuZhongyizhiyeQuestionMapper.getListByChapterId(chapterId);
//        }
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
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        String dataneme="tiku_"+name+"_question";
        map.put("dataname",dataneme);
        map.put("name",name);
        map.put("page",page);
        map.put("pageSize",pageSize);
        PageUtil.changeToPage(map);
        return tikuCollectionMapper.getTikuCollection(map);
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
