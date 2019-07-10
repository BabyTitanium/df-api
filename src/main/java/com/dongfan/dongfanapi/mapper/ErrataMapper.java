package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.Errata;
import com.dongfan.dongfanapi.entity.ErrataWithBLOBs;

public interface ErrataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ErrataWithBLOBs record);

    int insertSelective(ErrataWithBLOBs record);

    ErrataWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ErrataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ErrataWithBLOBs record);

    int updateByPrimaryKey(Errata record);
}