package com.dongfan.dongfanapi.configuration;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.entity.User;
import com.dongfan.dongfanapi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        String username = (String) getAvailablePrincipal(principalCollection);
        User user=userService.getUserByNickname(username);
        List<AuthRole> authRoles=userService.getUserAuthRoles(user.getId());
        List<AuthPermission> authPermissions=userService.getUserAuthPermissions(user.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for(AuthRole authRole:authRoles){
            simpleAuthorizationInfo.addRole(authRole.getCode());
        }
        for(AuthPermission authPermission:authPermissions){
            simpleAuthorizationInfo.addStringPermission(authPermission.getCode());
        }
        return simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user=userService.getUserByNickname(username);
        return new SimpleAuthenticationInfo(username, user.getNickName(), getName());
    }
}
