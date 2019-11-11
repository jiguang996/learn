package com.gyf.test;

import com.gyf.service.IUserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.cfg.C3P0Config;
import com.mchange.v2.c3p0.cfg.C3P0ConfigUtils;
import com.mchange.v2.c3p0.impl.C3P0PooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class Lesson10 {

    @Test
    public void  test01() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource= new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("jg13037583631");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql:///spring_day02?serverTimezone=UTC");
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        JdbcTemplate jdbcTemplate= new JdbcTemplate(comboPooledDataSource);
        jdbcTemplate.update("insert  into  t_user (username,password) values (?,?);", "ji","123");


    }

}

