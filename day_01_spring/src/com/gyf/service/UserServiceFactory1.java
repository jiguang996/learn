package com.gyf.service;

import com.gyf.service.Impl.UserServiceImpl;

public class UserServiceFactory1 {
    public   IUserService createUserService(){
        return   new UserServiceImpl();
    }
}
