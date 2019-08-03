package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}