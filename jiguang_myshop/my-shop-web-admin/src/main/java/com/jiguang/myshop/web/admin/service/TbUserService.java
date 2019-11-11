package com.jiguang.myshop.web.admin.service;



import com.jiguang.myshop.commons.dto.BaseResult;
import com.jiguang.myshop.commons.dto.PageInfo;
import com.jiguang.myshop.domain.TbUser;

import java.util.List;

public interface TbUserService  {


    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     * 查询所有用户
     * @return
     */
    List<TbUser> findAll();

    /**
     * 保存用户
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 通过id 删除
     * @param id
     */
    void  delete(Long id);

    /**
     * 更新用户
     * @param tbUser
     */
    void  update(TbUser tbUser);

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    TbUser findById(Long id);



    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String [] ids);

    /**
     * 分页查询
     * @param start
     * @param draw
     * @param length
     * @return
     */
    PageInfo<TbUser> page(int start, int draw, int length, TbUser tbUser);

    /**
     * 查询总笔数
     * @param
     * @return
     */
    int count(TbUser tbUser);
}
