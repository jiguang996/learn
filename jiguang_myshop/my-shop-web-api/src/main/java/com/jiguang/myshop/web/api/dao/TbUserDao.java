package com.jiguang.myshop.web.api.dao;

import com.jiguang.myshop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 *会员登录
 * @Author ji
 * @Date 2019/10/25 9:57
 * @Version 1.0
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
