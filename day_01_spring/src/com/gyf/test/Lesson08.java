package com.gyf.test;

import com.gyf.factory.MyBeanFactory;
import com.gyf.factory.MyBeanFactory02;
import com.gyf.service.IUserService;
import com.gyf.service.Impl.UserServiceImpl;
import org.junit.Test;

public class Lesson08 {
    //jdk实现aop

    @Test
    public void  test01() {
        IUserService iUserService=  new UserServiceImpl();
        iUserService.addUser();
        iUserService.deleteUser();
        iUserService.updateUser();

    }

    @Test
    public void  test02() {
        IUserService iUserService= MyBeanFactory02.createUserService();
        iUserService.addUser();
        iUserService.deleteUser();;
        iUserService.updateUser();

    }

}

