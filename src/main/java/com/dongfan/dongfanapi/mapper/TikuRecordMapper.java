package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.TikuRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface TikuRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TikuRecord record);

    int insertSelective(TikuRecord record);

    TikuRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TikuRecord record);

    int updateByPrimaryKey(TikuRecord record);

    List getXiyizhiyeRecord(int userId);
    List getXiyiRecord(int userId);
    List getZhongyizhiyeRecord(int userId);
    List getKouqiangRecord(int userId);
    List getZhiyexiyaoshiRecord(int userId);
    List getZhiyezhongyaoshiRecord(int userId);
}