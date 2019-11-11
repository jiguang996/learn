package com.jiguang.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.jiguang.ssm.dao.IRoleDao;
import com.jiguang.ssm.domain.Permission;
import com.jiguang.ssm.domain.Role;
import com.jiguang.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);

        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRole(String id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void addPermissionToRole(String[] permissionIds, String roleId) {
        for(String permissionid:permissionIds){
            roleDao.addPermissionToRole(permissionid,roleId);
        }
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId) ;
    }
}
