package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.CourseRecord;

public interface CourseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseRecord record);

    int insertSelective(CourseRecord record);

    CourseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseRecord record);

    int updateByPrimaryKey(CourseRecord record);
}