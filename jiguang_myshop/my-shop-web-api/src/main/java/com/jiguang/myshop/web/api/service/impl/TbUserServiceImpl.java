package com.jiguang.myshop.web.api.service.impl;

import com.jiguang.myshop.domain.TbUser;
import com.jiguang.myshop.web.api.dao.TbUserDao;
import com.jiguang.myshop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser tbUser1 = tbUserDao.login(tbUser);
        if (tbUser1 != null) {
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(tbUser1.getPassword())) {
                return tbUser1;
            }
        }
        return null;
    }
}
