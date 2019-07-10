package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeQuestion;
import com.dongfan.dongfanapi.entity.TikuXiyizhiyeQuestionWithBLOBs;

public interface TikuXiyizhiyeQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyeQuestionWithBLOBs record);

    int insertSelective(TikuXiyizhiyeQuestionWithBLOBs record);

    TikuXiyizhiyeQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuXiyizhiyeQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuXiyizhiyeQuestion record);
}