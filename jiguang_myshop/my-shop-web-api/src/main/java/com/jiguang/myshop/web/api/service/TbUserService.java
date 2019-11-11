package com.jiguang.myshop.web.api.service;

import com.jiguang.myshop.domain.TbUser;

/**
 * 会员管理
 * @Author ji
 * @Date 2019/10/25 9:59
 * @Version 1.0
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
