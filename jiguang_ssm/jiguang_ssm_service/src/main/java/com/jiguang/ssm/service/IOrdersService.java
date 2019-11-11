package com.jiguang.ssm.service;


import com.jiguang.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(Integer page,Integer size );

    Orders findById(String orderId);
}
