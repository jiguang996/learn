package com.jiguang.ssm.service;


import com.jiguang.ssm.domain.Permission;
import com.jiguang.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll(Integer page, Integer size);

    void save(Role role);

    Role findById(String id);

    void deleteRole(String id);

    void addPermissionToRole(String[] permissionIds, String roleId);



    List<Permission> findOtherPermissions(String roleId);
}
