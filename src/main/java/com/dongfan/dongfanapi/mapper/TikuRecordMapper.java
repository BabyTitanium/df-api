package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuRecord record);

    int insertSelective(TikuRecord record);

    TikuRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuRecord record);

    int updateByPrimaryKey(TikuRecord record);
}