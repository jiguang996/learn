package com.gyf.itedu.test;


import com.gyf.itedu.model.User;
import com.gyf.itedu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Demo01 {

    @Autowired
    private IUserService userService;
    @Test
    public  void test1(){
        //保存一个用户
        User user = new User("gyf","123",10);
        userService.register(user);
    }
}
