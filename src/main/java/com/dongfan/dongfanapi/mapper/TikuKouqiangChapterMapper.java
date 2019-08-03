package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuKouqiangChapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuKouqiangChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuKouqiangChapter record);

    int insertSelective(TikuKouqiangChapter record);

    TikuKouqiangChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuKouqiangChapter record);

    int updateByPrimaryKey(TikuKouqiangChapter record);
}