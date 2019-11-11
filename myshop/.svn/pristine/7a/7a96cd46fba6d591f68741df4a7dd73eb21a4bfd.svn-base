package com.jiguang.myshop.web.admin.service.impl;

import com.jiguang.myshop.domain.TbContentCategory;
import com.jiguang.myshop.web.admin.dao.TbContentCategoryDao;
import com.jiguang.myshop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/20 16:23
 * @Version 1.0
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao contentCategoryDao;
    @Override
    public List<TbContentCategory> findAll() {
        return contentCategoryDao.findAll();
    }

    @Override
    public TbContentCategory findById(Long id) {
        return contentCategoryDao.findById(id);
    }
}
