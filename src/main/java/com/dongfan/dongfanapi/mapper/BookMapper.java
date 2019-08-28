package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);


    List<Book> getBookList(@Param("pageStart") int pageStart,@Param("pageSize")int pageSize);
}