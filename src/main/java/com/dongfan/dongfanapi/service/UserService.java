package com.dongfan.dongfanapi.service;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.untils.PageResult;

import java.util.List;
import java.util.Map;


public interface UserService {

    PageResult getUserList(Map map);

    User getUserByNickname(String nickname);//根据昵称获取用户信息

    User getUserByOpenId(String openId);//根据openId获取用户信息

    User getUserByUnionId(String unionId);//根据unionId获取用户信息

    List<AuthRole> getUserAuthRoles(int userId);//根据用户ID获取用户角色

    List<AuthPermission> getUserAuthPermissions(int userId);//根据用户ID获取用户权限

    void adduser(User user);

    User getUserById(int userId);
}
