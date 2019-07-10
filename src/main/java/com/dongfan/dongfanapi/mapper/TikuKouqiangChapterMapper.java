package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuKouqiangChapter;

public interface TikuKouqiangChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuKouqiangChapter record);

    int insertSelective(TikuKouqiangChapter record);

    TikuKouqiangChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuKouqiangChapter record);

    int updateByPrimaryKey(TikuKouqiangChapter record);
}