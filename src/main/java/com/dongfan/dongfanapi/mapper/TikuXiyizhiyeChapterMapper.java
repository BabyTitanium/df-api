package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeChapter;

public interface TikuXiyizhiyeChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyeChapter record);

    int insertSelective(TikuXiyizhiyeChapter record);

    TikuXiyizhiyeChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyeChapter record);

    int updateByPrimaryKey(TikuXiyizhiyeChapter record);
}