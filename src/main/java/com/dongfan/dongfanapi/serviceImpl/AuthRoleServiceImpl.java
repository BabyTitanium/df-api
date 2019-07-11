package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthRole;
import com.dongfan.dongfanapi.mapper.AuthRoleMapper;
import com.dongfan.dongfanapi.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lll
 * @Date: 2019/7/11 20:44
 * @Version 1.0
 */

@Service
public class AuthRoleServiceImpl implements AuthRoleService {

    @Resource
    private AuthRoleMapper authRoleMapper;

    @Override
    public void addRole(AuthRole authRole) {
        authRoleMapper.insertSelective(authRole);
    }
}
