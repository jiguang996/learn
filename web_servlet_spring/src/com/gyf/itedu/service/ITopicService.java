package com.gyf.itedu.service;

import com.gyf.itedu.model.Topic;

import java.util.List;

public interface ITopicService {

    /**
     * 返回所有贴吧
     * @param key
     * @return
     */
    public List<Topic> getAll(String key);

    public void save(Topic topic);
}
