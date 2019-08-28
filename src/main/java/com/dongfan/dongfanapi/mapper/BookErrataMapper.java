package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.BookErrata;
import com.dongfan.dongfanapi.entity.BookErrataWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookErrataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookErrataWithBLOBs record);

    int insertSelective(BookErrataWithBLOBs record);

    BookErrataWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookErrataWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookErrataWithBLOBs record);

    int updateByPrimaryKey(BookErrata record);

    List<Map> getUserBookErrInfo(@Param("userId")int userId,@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

    List<Map> getOneBookErrInfo(@Param("id")int id,@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

    List<Map> getAllBookErrList(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);
}