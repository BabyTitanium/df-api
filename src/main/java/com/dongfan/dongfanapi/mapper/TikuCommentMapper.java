package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuComment record);

    int insertSelective(TikuComment record);

    TikuComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuComment record);

    int updateByPrimaryKey(TikuComment record);
}