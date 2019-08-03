package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.Live;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Live record);

    int insertSelective(Live record);

    Live selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Live record);

    int updateByPrimaryKeyWithBLOBs(Live record);

    int updateByPrimaryKey(Live record);
}