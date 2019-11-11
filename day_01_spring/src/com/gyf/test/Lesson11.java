package com.gyf.test;

import com.gyf.dao.StudentDao;
import com.gyf.model.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class Lesson11 {

    @Test
    public void  test01() throws PropertyVetoException {
//        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("jg13037583631");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///spring_day02?serverTimezone=UTC");
//        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        ApplicationContext context1=new ClassPathXmlApplicationContext("beans10.xml");
        //2.


        StudentDao studentDao= (StudentDao) context1.getBean("sutdentDao");
        Student student= new Student();
        student.setPassword("111");
        student.setUsername("kji");
        studentDao.save(student);



    }

}

