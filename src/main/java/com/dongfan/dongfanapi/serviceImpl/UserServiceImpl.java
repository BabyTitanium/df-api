package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(Map condition) {
        Map<String,Object> map=new HashMap<>();
        return userMapper.getUserList(condition);
    }

    @Override
    public User getUserByNickname(String nickname) {
            User user=userMapper.selectUserByNickname(nickname);
            System.out.println(user.getPhone());
            return user;
    }
}
