package com.jiguang.myshop.web.admin.dao;

import com.jiguang.myshop.commons.persistence.BaseDao;
import com.jiguang.myshop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
