package com.gyf.service;

import com.gyf.service.Impl.UserServiceImpl;

public class UserServiceFactory {
    public  static IUserService createUserService(){
        return   new UserServiceImpl();
    }
}
