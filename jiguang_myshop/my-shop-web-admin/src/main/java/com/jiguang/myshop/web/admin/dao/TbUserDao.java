package com.jiguang.myshop.web.admin.dao;


import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.domain.TbContent;
import com.jiguang.myshop.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao  {

    /**
     * 查询所有用户
     * @return
     */
    List<TbUser> findAll();

    /**
     * 添加用户
     * @param tbUser
     */
    void save(TbUser tbUser);

    /**
     * 根据id删除用户
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */

    TbUser findById(Long id);

    /**
     * 多选删除
     * @param ids
     */
    void  deleteMulti(String [] ids);

    /**
     * 更新用户
     * @param user
     */
    void  update(TbUser user);

    /**
     * 根据email 查询用户信息
     * @param email
     * @return
     */
    TbUser findByEmail(String email);

    /**
     * 分页查询
     * @param params
     * @return
     */
    List<TbUser> page(Map<String,Object> params);

    /**
     * 查询总笔数
     * @param tbUser
     * @return
     */
    Integer count(TbUser tbUser);
}
