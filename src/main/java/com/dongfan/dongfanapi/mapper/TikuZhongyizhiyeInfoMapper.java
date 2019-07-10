package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhongyizhiyeInfoWithBLOBs;

public interface TikuZhongyizhiyeInfoMapper {
    int insert(TikuZhongyizhiyeInfoWithBLOBs record);

    int insertSelective(TikuZhongyizhiyeInfoWithBLOBs record);
}