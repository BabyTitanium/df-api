package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TikuCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuComment record);

    int insertSelective(TikuComment record);

    TikuComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuComment record);

    int updateByPrimaryKey(TikuComment record);

    void deleteByUserAndId(@Param("userId")int userId,@Param("id") int id);

    List<TikuComment> getTikuCommentList(@Param("name") String name,@Param("questionId")int questionId);
}