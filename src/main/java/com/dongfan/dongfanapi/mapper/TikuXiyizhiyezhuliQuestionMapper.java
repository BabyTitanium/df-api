package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyezhuliQuestion;
import com.dongfan.dongfanapi.entity.TikuXiyizhiyezhuliQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyizhiyezhuliQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyezhuliQuestionWithBLOBs record);

    int insertSelective(TikuXiyizhiyezhuliQuestionWithBLOBs record);

    TikuXiyizhiyezhuliQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyezhuliQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuXiyizhiyezhuliQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuXiyizhiyezhuliQuestion record);
}