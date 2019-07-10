package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhongyizhiyeChapter;

public interface TikuZhongyizhiyeChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuZhongyizhiyeChapter record);

    int insertSelective(TikuZhongyizhiyeChapter record);

    TikuZhongyizhiyeChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuZhongyizhiyeChapter record);

    int updateByPrimaryKey(TikuZhongyizhiyeChapter record);
}