package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhiyezhongyaoshiQuestion;
import com.dongfan.dongfanapi.entity.TikuZhiyezhongyaoshiQuestionWithBLOBs;

public interface TikuZhiyezhongyaoshiQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuZhiyezhongyaoshiQuestionWithBLOBs record);

    int insertSelective(TikuZhiyezhongyaoshiQuestionWithBLOBs record);

    TikuZhiyezhongyaoshiQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuZhiyezhongyaoshiQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuZhiyezhongyaoshiQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuZhiyezhongyaoshiQuestion record);
}