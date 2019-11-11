package com.gyf.itedu.model;

import java.util.Date;

public class Reply {
    private Integer rid;
    private String replyContent;	//回复的内容
    private String ipAddr;			//作者（回复人）
    private Date createDate;		//回帖时间

    private Topic topic; //多对一：多个回复  属于 【一个主题】


    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", replyContent='" + replyContent + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
