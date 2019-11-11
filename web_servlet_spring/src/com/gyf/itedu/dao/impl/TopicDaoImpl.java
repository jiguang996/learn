package com.gyf.itedu.dao.impl;

import com.gyf.itedu.dao.ITopicDao;
import com.gyf.itedu.dao.IUserDao;
import com.gyf.itedu.model.Topic;
import com.gyf.itedu.model.User;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class TopicDaoImpl implements ITopicDao{

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Override
    public void save(Topic topic) {
        hibernateTemplate.save(topic);
    }

    @Override
    public List<Topic> getAll(String key) {

        List<Topic> list = hibernateTemplate.find("FROM Topic");
        return list;
    }
}
