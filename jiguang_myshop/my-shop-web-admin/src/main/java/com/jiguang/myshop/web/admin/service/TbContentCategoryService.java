package com.jiguang.myshop.web.admin.service;

import com.jiguang.myshop.domain.TbContentCategory;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/20 16:23
 * @Version 1.0
 */
public interface TbContentCategoryService {

    List<TbContentCategory> findAll();

    TbContentCategory findById(Long id);
}
