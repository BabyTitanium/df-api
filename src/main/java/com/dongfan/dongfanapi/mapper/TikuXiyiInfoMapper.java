package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyiInfoWithBLOBs;

public interface TikuXiyiInfoMapper {
    int insert(TikuXiyiInfoWithBLOBs record);

    int insertSelective(TikuXiyiInfoWithBLOBs record);
}