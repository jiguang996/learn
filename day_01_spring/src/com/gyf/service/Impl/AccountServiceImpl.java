package com.gyf.service.Impl;

import com.gyf.dao.AccountDao;
import com.gyf.dao.Impl.AccpuntDaoImpl;
import com.gyf.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String inner, String outer, Integer money) {
        accountDao.in(inner, money);
        accountDao.out(outer, money);
    }
}
