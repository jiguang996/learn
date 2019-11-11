package com.jiguang.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.jiguang.ssm.dao.IOrderDao;
import com.jiguang.ssm.domain.Orders;
import com.jiguang.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrderDao orderDao;


    @Override
    public List<Orders> findAll(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String orderId) {
        return orderDao.findById(orderId);
    }
}
