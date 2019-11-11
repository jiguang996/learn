package com.jiguang.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.jiguang.ssm.dao.IPermissionDao;
import com.jiguang.ssm.domain.Permission;
import com.jiguang.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public void deleteById(String id) {
        permissionDao.deleteById(id);
    }

    @Override
    public Permission findById(String id) {
        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save( permission);
    }

    @Override
    public List<Permission> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }
}
