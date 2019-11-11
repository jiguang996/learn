package com.jiguang.ssm.service;


import com.jiguang.ssm.domain.Role;
import com.jiguang.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(Integer page, Integer size);

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] ids);

    UserInfo login(String username);
}
