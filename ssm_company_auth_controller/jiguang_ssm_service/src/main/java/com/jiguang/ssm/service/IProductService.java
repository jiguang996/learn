package com.jiguang.ssm.service;


import com.jiguang.ssm.domain.Product;

import java.util.List;

public interface IProductService {


    List<Product> findAll(Integer page,Integer size);

    void save(Product product);
}
