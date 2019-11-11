package com.example.demo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.demo.mapper.TbUserMapper;
import com.example.demo.service.impl.TbUserService;
/**
 * @Author ji
 * @Date 2019/11/7 17:58
 * @Version 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;

}
