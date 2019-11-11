package com.gyf.test;

import com.gyf.model.User;
import com.gyf.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class Lesson05 {

    @Test
    public void  test01() {
        //以前用UserService方式,自己创建对象
       /* IUserSerivce userSerivce = new UserServiceImpl();
        userSerivce.add();*/

        //现在使用UserService方式从spring容器获取
        //1.加载beans.xml 这个spring的配置文件,内部就会创建对象
        ApplicationContext context1=new ClassPathXmlApplicationContext("beans6.xml");
        //2.
        IUserService iUserService= (IUserService) context1.getBean("userService");
        System.out.println(iUserService);
        User user= new User();
        user.setName("132213");

        //iUserService.save(user);

    }

}

