package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiQuestion;
import com.dongfan.dongfanapi.entity.TikuXiyiQuestionWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TikuXiyiQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyiQuestionWithBLOBs record);

    int insertSelective(TikuXiyiQuestionWithBLOBs record);

    TikuXiyiQuestionWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyiQuestionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TikuXiyiQuestionWithBLOBs record);

    int updateByPrimaryKey(TikuXiyiQuestion record);

    List<Map<String, Object>> getXiyiTiKuQuestion(@Param("start") int start, @Param("limit") int limit);

//    int getXiyiTiKuQuestionCount();

    List<Map> getListByChapterId(@Param("chapterId") int chapterId,@Param("userId")int userId);
}