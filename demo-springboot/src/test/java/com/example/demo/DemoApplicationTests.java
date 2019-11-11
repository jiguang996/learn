package com.example.demo;

import com.example.demo.domain.TbUser;
import com.example.demo.mapper.TbUserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

@Transactional
@Rollback
class DemoApplicationTests {


    @Autowired
    private TbUserMapper tbUserMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public  void  testSelectAll(){
        List<TbUser> tbUsers = tbUserMapper.selectAll();
        tbUsers.forEach(tbUser -> {
            System.out.println(tbUser);
        });
    }

    @Test
    public  void  testInsert(){

    }

    @Test
    public  void  testIPage(){
        PageHelper.startPage(1, 6);
        PageInfo<TbUser>  pageInfo=new PageInfo<>(tbUserMapper.selectAll());
        System.out.println(pageInfo);


    }
}
