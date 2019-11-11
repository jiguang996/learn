package com.jiguang.ssm.service;


import com.jiguang.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {


    void deleteById(String id);

    Permission findById(String id);

    void save(Permission permission);

    List<Permission> findAll(Integer page, Integer size);
}
