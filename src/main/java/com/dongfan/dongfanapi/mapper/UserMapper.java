package com.dongfan.dongfanapi.mapper;

import com.dongfan.dongfanapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUserList(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

    User selectUserByNickname(String nickname);

    User selectUserByOpenId(String openId);

    User selectUserByUnionId(String unionId);
}