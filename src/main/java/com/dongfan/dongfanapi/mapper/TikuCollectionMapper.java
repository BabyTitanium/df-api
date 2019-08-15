package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TikuCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuCollection record);

    int insertSelective(TikuCollection record);

    TikuCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuCollection record);

    int updateByPrimaryKey(TikuCollection record);

    List<Map> getTikuCollection(Map map);
}