package com.jiguang.myshop.web.admin.dao;

import com.jiguang.myshop.commons.persistence.BaseDao;
import com.jiguang.myshop.domain.TbContent;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentDao extends BaseDao<TbContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
