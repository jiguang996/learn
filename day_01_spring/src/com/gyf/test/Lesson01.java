package com.gyf.test;

import com.gyf.service.IUserService;
import com.gyf.service.Impl.UserServiceImpl;
import com.gyf.service.UserServiceFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson01 {

    @Test
    public void  test01() {
        //以前用UserService方式,自己创建对象
       /* IUserSerivce userSerivce = new UserServiceImpl();
        userSerivce.add();*/

        //现在使用UserService方式从spring容器获取
        //1.加载beans.xml 这个spring的配置文件,内部就会创建对象
        ApplicationContext context1=new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //2.

        IUserService userService2= (IUserService) context.getBean("userService2");
        IUserService userService3= (IUserService) context.getBean("userService2");



    }

}

