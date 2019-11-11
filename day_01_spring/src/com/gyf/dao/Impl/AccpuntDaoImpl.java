package com.gyf.dao.Impl;

import com.gyf.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccpuntDaoImpl  extends JdbcDaoSupport implements AccountDao {
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public void in(String inner, Integer money) {
        String sql=" update   account set money=money-? where username=?";
        getJdbcTemplate().update(sql, money,inner);
    }

    @Override
    public void out(String outer, Integer money) {
        String sql=" update   account set money=money+? where username=?";
        getJdbcTemplate().update(sql, money,outer);
    }
}
