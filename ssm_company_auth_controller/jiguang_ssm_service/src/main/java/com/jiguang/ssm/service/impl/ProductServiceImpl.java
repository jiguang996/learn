package com.jiguang.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.jiguang.ssm.dao.IProductDao;
import com.jiguang.ssm.domain.Product;
import com.jiguang.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll(Integer page,Integer size) {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return  productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
