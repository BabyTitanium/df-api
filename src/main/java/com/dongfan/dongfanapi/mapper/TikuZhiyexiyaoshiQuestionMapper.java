package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhiyexiyaoshiQuestion;
import com.dongfan.dongfanapi.entity.TikuZhiyexiyaoshiQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TikuZhiyexiyaoshiQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuZhiyexiyaoshiQuestionWithBLOBs record);

    int insertSelective(TikuZhiyexiyaoshiQuestionWithBLOBs record);

    TikuZhiyexiyaoshiQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuZhiyexiyaoshiQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuZhiyexiyaoshiQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuZhiyexiyaoshiQuestion record);

    List getListByChapterId(int chapterId);
}