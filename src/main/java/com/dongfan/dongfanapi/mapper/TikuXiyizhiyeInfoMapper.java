package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuXiyizhiyeInfoWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TikuXiyizhiyeInfoMapper {
    int insert(TikuXiyizhiyeInfoWithBLOBs record);

    int insertSelective(TikuXiyizhiyeInfoWithBLOBs record);
}