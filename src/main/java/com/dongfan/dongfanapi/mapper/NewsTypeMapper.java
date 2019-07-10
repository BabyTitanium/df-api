package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.NewsType;

public interface NewsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    NewsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);
}