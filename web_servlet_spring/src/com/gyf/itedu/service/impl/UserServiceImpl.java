package com.gyf.itedu.service.impl;

import com.gyf.itedu.dao.IUserDao;
import com.gyf.itedu.model.User;
import com.gyf.itedu.service.IUserService;

public class UserServiceImpl implements IUserService{

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user){
        userDao.add(user);
    }
}
