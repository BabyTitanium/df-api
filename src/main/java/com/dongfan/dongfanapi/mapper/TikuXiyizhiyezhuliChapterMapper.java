package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyezhuliChapter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyizhiyezhuliChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyizhiyezhuliChapter record);

    int insertSelective(TikuXiyizhiyezhuliChapter record);

    TikuXiyizhiyezhuliChapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyizhiyezhuliChapter record);

    int updateByPrimaryKey(TikuXiyizhiyezhuliChapter record);
}