package com.jiguang.myshop.web.admin.service;

import com.jiguang.myshop.commons.persistence.BaseService;
import com.jiguang.myshop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {
    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);
}
