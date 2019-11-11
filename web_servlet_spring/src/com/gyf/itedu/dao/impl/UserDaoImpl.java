package com.gyf.itedu.dao.impl;

import com.gyf.itedu.dao.IUserDao;
import com.gyf.itedu.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserDaoImpl implements IUserDao{

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(User user){
        hibernateTemplate.save(user);
    }
}
