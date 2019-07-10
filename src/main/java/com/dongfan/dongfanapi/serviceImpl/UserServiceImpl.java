package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(Map condition) {
        Map<String,Object> map=new HashMap<>();
        return userMapper.getUserList(condition);
    }
}
