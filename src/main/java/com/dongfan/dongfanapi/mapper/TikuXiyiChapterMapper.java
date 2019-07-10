package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiChapter;

public interface TikuXiyiChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyiChapter record);

    int insertSelective(TikuXiyiChapter record);

    TikuXiyiChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyiChapter record);

    int updateByPrimaryKey(TikuXiyiChapter record);
}