package com.jiguang.myshop.web.api.service.impl;

import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbContentCategory;
import com.jiguang.myshop.web.api.dao.TbContentDao;
import com.jiguang.myshop.web.api.dao.TbUserDao;
import com.jiguang.myshop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> findByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory=  new TbContentCategory();
        tbContentCategory.setId(categoryId);
        TbContent tbContent= new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.findByCategoryId(tbContent);

    }
}
