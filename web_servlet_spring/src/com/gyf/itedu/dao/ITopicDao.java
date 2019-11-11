package com.gyf.itedu.dao;

import com.gyf.itedu.model.Topic;

import java.util.List;

public interface ITopicDao {
    public void save(Topic topic);
    /**
     * 返回帖子列表
     * @param key
     * @return
     */
    public List<Topic> getAll(String key);
}
