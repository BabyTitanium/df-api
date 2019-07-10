package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.CourseChapter;

public interface CourseChapterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);

    CourseChapter selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseChapter record);

    int updateByPrimaryKeyWithBLOBs(CourseChapter record);

    int updateByPrimaryKey(CourseChapter record);
}