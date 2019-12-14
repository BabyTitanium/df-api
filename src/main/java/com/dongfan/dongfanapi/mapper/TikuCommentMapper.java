package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TikuCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuComment record);

    int insertSelective(TikuComment record);

    TikuComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuComment record);

    int updateByPrimaryKey(TikuComment record);

    void deleteByUserAndId(@Param("userId") int userId, @Param("id") int id);

    List<Map> getTikuCommentList(Map map);
    int getTikuCommentListCount(Map map);

    void deleteComment(@Param("ids")List ids);
}