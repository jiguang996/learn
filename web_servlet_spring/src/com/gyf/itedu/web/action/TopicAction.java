package com.gyf.itedu.web.action;


import com.gyf.itedu.model.Topic;
import com.gyf.itedu.service.ITopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class TopicAction extends ActionSupport implements ModelDriven<Topic>{

    private Topic topic = new Topic();
    private List<Topic> topicList;//属性提供get方法，数据会自动存在值栈中

    public List<Topic> getTopicList() {
        return topicList;
    }
    /**
     * 返回话题列表界面
     * @return topic_list
     */
    private ITopicService topicService;
    public void setTopicService(ITopicService topicService) {
        this.topicService = topicService;
    }

    public  String list(){
        //获取数据
        topicList = topicService.getAll(null);
        System.out.println("topicService :" + topicService);
        return "list";
    }

    public String save(){
        //1.表单数据封装
        //帖子创建时间
        topic.setCreateDate(new Date());
        //帖子的id地址
        //action怎么获取请求对象
        topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        System.out.println(topic);

        //2.调用service
        topicService.save(topic);
        //获取数据
        //List<Topic> topicList = topicService.getAll(null);

        return "list";
    }

    @Override
    public Topic getModel() {
        return topic;
    }

    /**
     * 通过帖子关键字探索相关数据
     * @return
     */
    private String key;//提供set 【Alt+ 4 显示隐藏控制台】

    public void setKey(String key) {
        this.key = key;
    }

    public String search(){
        System.out.println("搜索的关键字:" + key);

        topicList = topicService.getAll(key);
        return "list";
    }
}
