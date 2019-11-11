package com.gyf.itedu.service.impl;

import com.gyf.itedu.dao.ITopicDao;
import com.gyf.itedu.model.Topic;
import com.gyf.itedu.service.ITopicService;

import java.util.List;

public class TopicServiceImpl implements ITopicService{

    private ITopicDao topicDao;

    public void setTopicDao(ITopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Topic> getAll(String key) {
        return topicDao.getAll(key);
    }

    @Override
    public void save(Topic topic) {
        topicDao.save(topic);
    }
}
