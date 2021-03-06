package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface TikuRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuRecord record);

    int insertSelective(TikuRecord record);

    TikuRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuRecord record);

    int updateByPrimaryKey(TikuRecord record);

    List<Map> getQuestionList(Map map);
    int getQuestionListCount(Map map);
    List<Map> getChapterList(Map map);
    int getChapterListCount(Map map);
    Map getTikuQuestionById(@Param("dataname")String dataname,@Param("userId")int questionId);
}