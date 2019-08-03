package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiYearScore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyiYearScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuXiyiYearScore record);

    int insertSelective(TikuXiyiYearScore record);

    TikuXiyiYearScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuXiyiYearScore record);

    int updateByPrimaryKey(TikuXiyiYearScore record);
}