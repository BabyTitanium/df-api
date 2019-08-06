package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhongyizhiyeQuestion;
import com.dongfan.dongfanapi.entity.TikuZhongyizhiyeQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TikuZhongyizhiyeQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuZhongyizhiyeQuestionWithBLOBs record);

    int insertSelective(TikuZhongyizhiyeQuestionWithBLOBs record);

    TikuZhongyizhiyeQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuZhongyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuZhongyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuZhongyizhiyeQuestion record);

    List getListByChapterId(int chapterId);


}