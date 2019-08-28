package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.mapper.AuthPermissionMapper;
import com.dongfan.dongfanapi.service.AuthPermissionService;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lll
 * @Date: 2019/8/18 16:16
 * @Version 1.0
 */
@Service
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionMapper authPermissionMapper;
    @Override
    public List<AuthPermission> getAllPermissions(int page,int pageSize) {
        int pageStart=PageUtil.getStart(page,pageSize);
        return authPermissionMapper.getAllPermissions(pageStart,pageSize);
    }

    @Override
    public void addPermission(AuthPermission authPermission) {
        authPermissionMapper.insertSelective(authPermission);
    }

    @Override
    public void deletePermission(int id) {
        authPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editPermission(AuthPermission authPermission) {
        authPermissionMapper.updateByPrimaryKeySelective(authPermission);
    }
}
