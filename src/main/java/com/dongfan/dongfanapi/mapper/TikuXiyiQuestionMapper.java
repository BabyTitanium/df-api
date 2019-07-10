package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiQuestion;
import com.dongfan.dongfanapi.entity.TikuXiyiQuestionWithBLOBs;

public interface TikuXiyiQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyiQuestionWithBLOBs record);

    int insertSelective(TikuXiyiQuestionWithBLOBs record);

    TikuXiyiQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyiQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuXiyiQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuXiyiQuestion record);
}