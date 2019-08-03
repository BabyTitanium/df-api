package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeQuestion;
import com.dongfan.dongfanapi.entity.TikuXiyizhiyeQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TikuXiyizhiyeQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyeQuestionWithBLOBs record);

    int insertSelective(TikuXiyizhiyeQuestionWithBLOBs record);

    TikuXiyizhiyeQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuXiyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuXiyizhiyeQuestion record);

    List getListByChapterId(int chapterId);
}