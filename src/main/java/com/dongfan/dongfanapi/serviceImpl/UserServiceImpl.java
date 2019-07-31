package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.AuthPermissionMapper;
import com.dongfan.dongfanapi.mapper.AuthRoleMapper;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Resource
    private AuthRoleMapper authRoleMapper;
    @Resource
    private AuthPermissionMapper authPermissionMapper;

    @Override
    public List<User> getUserList(Map condition) {
        return userMapper.getUserList(condition);
    }

    @Override
    public User getUserByNickname(String nickname) {
        User user = userMapper.selectUserByNickname(nickname);
        return user;
    }

    @Override
    public User getUserByOpenId(String openId) {
        return userMapper.selectUserByOpenId(openId);
    }

    @Override
    public User getUserByUnionId(String unionId) {
        return userMapper.selectUserByUnionId(unionId);
    }

    @Override
    public List<AuthRole> getUserAuthRoles(int userId) {
        return authRoleMapper.selectUserAuthRoles(userId);
    }

    @Override
    public List<AuthPermission> getUserAuthPermissions(int userId) {
        return authPermissionMapper.selectUserAuthPermissions(userId);
    }

    @Override
    public void adduser(User user) {
        userMapper.insertSelective(user);
    }


}
