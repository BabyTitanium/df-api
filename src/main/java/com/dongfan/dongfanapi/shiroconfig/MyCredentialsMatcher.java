package com.dongfan.dongfanapi.shiroconfig;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @Author: lll
 * @Date: 2019/6/11 21:20
 * @Version 1.0
 */
public class MyCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        System.out.println("密码验证!!!!!!");
        return true;
    }
}
