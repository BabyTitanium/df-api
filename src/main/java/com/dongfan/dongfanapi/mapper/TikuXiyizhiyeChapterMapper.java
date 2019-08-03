package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeChapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyizhiyeChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyeChapter record);

    int insertSelective(TikuXiyizhiyeChapter record);

    TikuXiyizhiyeChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyeChapter record);

    int updateByPrimaryKey(TikuXiyizhiyeChapter record);
}