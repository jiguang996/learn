package com.jiguang.myshop.web.admin.service;

import com.jiguang.myshop.commons.persistence.BaseService;
import com.jiguang.myshop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    /**
     * 用户登录
     *
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);
}
