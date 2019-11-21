package com.jiguang.oauth2.resource.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jiguang.oauth2.resource.mapper.TbContentCategoryMapper;
import com.jiguang.oauth2.resource.service.TbContentCategoryService;
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

}
