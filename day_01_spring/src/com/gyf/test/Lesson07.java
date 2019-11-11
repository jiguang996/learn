//package com.gyf.test;
//
//import com.gyf.action.UserAction;
//import com.gyf.factory.MyBeanFactory;
//import com.gyf.service.IUserService;
//import com.gyf.service.Impl.UserServiceImpl;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class Lesson07 {
//    //jdk实现aop
//
//    @Test
//    public void  test01() {
//        IUserService iUserService=  new UserServiceImpl();
//        iUserService.addUser();
//        iUserService.deleteUser();
//        iUserService.updateUser();
//
//    }
//
//    @Test
//    public void  test02() {
//        IUserService iUserService= MyBeanFactory.createUserService();
//        iUserService.addUser();
//        iUserService.deleteUser();;
//        iUserService.updateUser();
//
//    }
//
//}

