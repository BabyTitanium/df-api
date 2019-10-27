package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.TikuCollection;
import com.dongfan.dongfanapi.entity.TikuComment;
import com.dongfan.dongfanapi.entity.TikuRecord;
import com.dongfan.dongfanapi.mapper.*;
import com.dongfan.dongfanapi.params.TikuQuestionInfo;
import com.dongfan.dongfanapi.service.QuestionService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private TikuQuestionMapper tikuQuestionMapper;
    @Resource
    private TikuCollectionMapper tikuCollectionMapper;
    @Resource
    private TikuXiyizhiyezhuliQuestionMapper tikuXiyizhiyezhuliQuestionMapper;
    @Override
    public void addQuestionRecord(TikuRecord tikuRecord) {
        tikuRecordMapper.insertSelective(tikuRecord);
    }
//  xiyi     kouqiang     xiyizhiye    zhiyexiyaoshi    zhiyezhongyaoshi    zhongyizhiye

    @Override
    public PageResult getQuestionListByChapter(int userId, String name,Map map) {
        String dataname="tiku_"+name+"_question";
        map.put("userId",userId);
        map.put("name",name);
        map.put("dataname",dataname);
        PageUtil.pageCondition(map);
        List<Map>  list=tikuRecordMapper.getQuestionList(map);
        int count=tikuRecordMapper.getQuestionListCount(map);
        return PageUtil.getPageResult(list,count,map);
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
    public PageResult getTikuCollection(String name, Map map) {
        String dataneme="tiku_"+name+"_question";
        map.put("dataname",name);
        PageUtil.pageCondition(map);
        List list=tikuCollectionMapper.getTikuCollection(map);
        int count=tikuCollectionMapper.getTikuCollectionCount(map);
        return PageUtil.getPageResult(list,count,map);
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
    public PageResult getTikuCommentList(Map map) {
        PageUtil.pageCondition(map);
        List list=tikuCommentMapper.getTikuCommentList(map);
        int count=tikuCommentMapper.getTikuCommentListCount(map);
        return PageUtil.getPageResult(list,count,map);
    }

    @Override
    public PageResult getAllQuestionList(String name,Map map){
        String dataname="tiku_"+name+"_question";
        map.put("dataname",dataname);
        PageUtil.pageCondition(map);
        List list=tikuQuestionMapper.getAllQuestionList(map);
        int count=tikuQuestionMapper.getAllQuestionListCount(map);
        return PageUtil.getPageResult(list,count,map);
    }

    @Override
    public void deleteQuestion(String name, List ids) {
        String dataname="tiku_"+name+"_question";
        tikuQuestionMapper.deleteQuestion(name,ids);
    }

    @Override
    public void addQuestion(TikuQuestionInfo tikuInfo) {
        String name=tikuInfo.getTiku();
        if(name.equals("xiyi")){
            tikuXiyiQuestionMapper.insertSelective(tikuInfo.getTikuXiyiQuestion());
        }else if(name.equals("xiyizhiye")){
            tikuXiyizhiyeQuestionMapper.insertSelective(tikuInfo.getTikuXiyizhiyeQuestion());
        }else if (name.equals("kouqiang")){
            tikuKouqiangQuestionMapper.insertSelective(tikuInfo.getTikuKouqiangQuestion());
        }else if (name.equals("xiyizhiyezhuli")){
            tikuXiyizhiyeQuestionMapper.insertSelective(tikuInfo.getTikuXiyizhiyeQuestion());
        }else if (name.equals("zhiyexiyaoshi")){
            tikuZhiyexiyaoshiQuestionMapper.insertSelective(tikuInfo.getTikuZhiyexiyaoshiQuestion());
        }else if (name.equals("zhiyezhongyaoshi")){
            tikuZhiyezhongyaoshiQuestionMapper.insertSelective(tikuInfo.getTikuZhiyezhongyaoshiQuestion());
        }
    }
}
