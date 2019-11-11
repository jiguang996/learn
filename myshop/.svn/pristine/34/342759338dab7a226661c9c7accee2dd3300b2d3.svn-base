package com.jiguang.myshop.web.admin.dao;

import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author ji
 * @Date 2019/10/20 19:03
 * @Version 1.0
 */

@Repository
public interface TbContentDao {
    /**
     * 查询所有内容
     * @return
     */
    List<TbContent> findAll();

    /**
     * 添加内容
     * @param tbContent
     */
    void save(TbContent tbContent);

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
     * @param map
     * @return
     */
    List<TbContent> page(Map<String,Object> map);

    /**
     * 查询总笔数
     * @param tbContent
     * @return
     */
    int count(TbContent tbContent);



}
