package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeInfoWithBLOBs;

public interface TikuXiyizhiyeInfoMapper {
    int insert(TikuXiyizhiyeInfoWithBLOBs record);

    int insertSelective(TikuXiyizhiyeInfoWithBLOBs record);
}