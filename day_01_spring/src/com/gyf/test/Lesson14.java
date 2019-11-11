package com.gyf.test;

import com.gyf.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;

public class Lesson14 {

    @Test
    public void  test01() throws PropertyVetoException {
//        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("jg13037583631");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///spring_day02?serverTimezone=UTC");
//        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        ApplicationContext context1=new ClassPathXmlApplicationContext("beans13.xml");
        //2.

        IAccountService iAccountService= (IAccountService) context1.getBean("proxyAccountService");
        iAccountService.transfer("rose", "jack", 222);


    }

}

