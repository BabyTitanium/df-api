package com.dongfan.dongfanapi.serviceImpl;

import com.dongfan.dongfanapi.entity.AuthPermission;
import com.dongfan.dongfanapi.mapper.AuthPermissionMapper;
import com.dongfan.dongfanapi.service.AuthPermissionService;
import com.dongfan.dongfanapi.untils.PageResult;
import com.dongfan.dongfanapi.untils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public PageResult getAllPermissions(Map map) {
        PageUtil.pageCondition(map);
        List list=authPermissionMapper.getAllPermissions(map);
        int count=authPermissionMapper.getAllPermissionsCount(map);
        return PageUtil.getPageResult(list,count,map);
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
