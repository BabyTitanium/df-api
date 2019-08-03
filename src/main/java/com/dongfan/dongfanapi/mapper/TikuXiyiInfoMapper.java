package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiInfoWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyiInfoMapper {
    int insert(TikuXiyiInfoWithBLOBs record);

    int insertSelective(TikuXiyiInfoWithBLOBs record);
}