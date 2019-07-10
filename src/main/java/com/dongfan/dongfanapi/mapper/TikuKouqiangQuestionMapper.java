package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuKouqiangQuestion;
import com.dongfan.dongfanapi.entity.TikuKouqiangQuestionWithBLOBs;

public interface TikuKouqiangQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuKouqiangQuestionWithBLOBs record);

    int insertSelective(TikuKouqiangQuestionWithBLOBs record);

    TikuKouqiangQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuKouqiangQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuKouqiangQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuKouqiangQuestion record);
}