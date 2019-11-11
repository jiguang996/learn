package com.jiguang.myshop.web.admin.service;

import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbContentCategory;
import com.jiguang.myshop.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @Author ji
 * @Date 2019/10/20 16:23
 * @Version 1.0
 */
public interface TbContentService {
    /**
     * 查询所有内容
     * @return
     */
    List<TbContent> findAll();

    /**
     * 添加内容
     * @param tbContent
     */
    BaseResult save(TbContent tbContent);

    /**
     * 根据id删除内容
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询内容
     * @param id
     * @return
     */

    TbContent findById(Long id);

    /**
     * 多选删除
     * @param ids
     */
    void  deleteMulti(String [] ids);

    /**
     * 更新内容
     * @param tbContent
     */
    void  update(TbContent tbContent);


    /**
     * 分页查询
     * @param start
     * @param draw
     * @param length
     * @return
     */
    PageInfo<TbContent> page(int start, int draw, int length, TbContent tbContent);


    /**
     * 查询总笔数
     * @param tbContent
     * @return
     */
    int count(TbContent tbContent);


}
