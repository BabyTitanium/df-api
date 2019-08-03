package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuZhongyizhiyeInfoWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuZhongyizhiyeInfoMapper {
    int insert(TikuZhongyizhiyeInfoWithBLOBs record);

    int insertSelective(TikuZhongyizhiyeInfoWithBLOBs record);
}