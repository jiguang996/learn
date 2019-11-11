package com.gyf.test;

import com.gyf.model.People;
import com.gyf.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lesson02 {

    @Test
    public void  test01() {
        //以前用UserService方式,自己创建对象
       /* IUserSerivce userSerivce = new UserServiceImpl();
        userSerivce.add();*/

        //现在使用UserService方式从spring容器获取
        //1.加载beans.xml 这个spring的配置文件,内部就会创建对象
        ApplicationContext context1=new ClassPathXmlApplicationContext("beans3.xml");
        //2.
        People p1= (People) context1.getBean("people1");
        People p2= (People) context1.getBean("people2");
        System.out.println(p1);
        System.out.println(p2);


    }

}

