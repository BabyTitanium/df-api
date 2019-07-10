package com.dongfan.dongfanapi.configuration;

import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: lll
 * @Date: 2019/6/10 20:54
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        User user=userService.getUserByNickname(username);
        System.out.println(user.getPhone());
        int i=0;
        i=i+10;
        return new SimpleAuthenticationInfo(username, user.getNickName(), getName());
       // return new SimpleAuthenticationInfo("1", "1", getName());

    }
}
