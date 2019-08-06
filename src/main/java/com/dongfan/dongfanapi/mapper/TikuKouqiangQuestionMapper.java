package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuKouqiangQuestion;
import com.dongfan.dongfanapi.entity.TikuKouqiangQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TikuKouqiangQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuKouqiangQuestionWithBLOBs record);

    int insertSelective(TikuKouqiangQuestionWithBLOBs record);

    TikuKouqiangQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuKouqiangQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuKouqiangQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuKouqiangQuestion record);

    List<Map> getListByChapterId(@Param("chapterId") int chapterId,@Param("userId") int userId);
}