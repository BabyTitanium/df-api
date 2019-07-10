package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> getUserList(Map map);
    User getUserByNickname(String nickname);
}
