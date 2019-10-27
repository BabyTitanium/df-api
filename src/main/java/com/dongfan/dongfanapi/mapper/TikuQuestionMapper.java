package com.dongfan.dongfanapi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: lll
 * @Date: 2019/10/20 9:55
 * @Version 1.0
 */

@Mapper
public interface TikuQuestionMapper {
    List<Map> getAllQuestionList(Map map);
    int getAllQuestionListCount(Map map);
    void deleteQuestion(@Param("dataname")String dataname,@Param("ids")List ids);
}
