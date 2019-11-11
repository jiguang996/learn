package com.gyf.service.Impl;

import com.gyf.model.User;
import com.gyf.service.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {


    @Override
    public void addUser() {
        System.out.println("添加用户");

    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }

    @Override
    public String telById() {
        return "110";
    }
}
