package com.jiguang.myshop.web.admin.dao;

import com.jiguang.myshop.commons.persistence.BaseDao;
import com.jiguang.myshop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/10/20 16:29
 * @Version 1.0
 */
@Repository
public interface TbContentCategoryDao extends BaseDao{


    List<TbContentCategory> findAll();

    TbContentCategory findById(Long id);
}
