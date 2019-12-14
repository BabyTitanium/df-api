package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.AuthRoleUser;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.mapper.AuthPermissionMapper;
import com.dongfan.dongfanapi.mapper.AuthRoleMapper;
import com.dongfan.dongfanapi.mapper.AuthRoleUserMapper;
import com.dongfan.dongfanapi.mapper.UserMapper;
import com.dongfan.dongfanapi.params.UserRole;
import com.dongfan.dongfanapi.params.UserRoles;
import com.dongfan.dongfanapi.service.UserService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
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
    @Resource
    private AuthRoleUserMapper authRoleUserMapper;
    @Override
    public PageResult getUserList(Map map) {
        PageUtil.pageCondition(map);
        List list=userMapper.getUserList(map);
        int count=userMapper.getUserListCount(map);
        return PageUtil.getPageResult(list,count,map);
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

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void deleteUserRole(int id) {
        authRoleUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addUserRole(AuthRoleUser authRoleUser) {
        AuthRoleUser a=authRoleUserMapper.getAuthRoleUser(authRoleUser.getUserId(),authRoleUser.getRoleId());
        if (a==null){
            authRoleUserMapper.insert(authRoleUser);
        }
    }

    @Override
    public List getUserRoles(int id) {
        List list=authRoleUserMapper.getUserRoles(id);
        return list;
    }

    @Override
    public void deleteUserRoles(int userId) {
        authRoleUserMapper.deleteUserRoles(userId);
    }

    @Override
    public void addUserRoles(UserRoles userRoles) {
        List list=Arrays.asList(userRoles.getRoleIds().split(","));
        authRoleUserMapper.addUserRoles(userRoles.getUserId(),list);
    }


}
