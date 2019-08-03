package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.NewsType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    NewsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);
}