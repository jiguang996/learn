package com.jiguang.hello.apache.dubbo.provider.service;

import java.io.Serializable;

/**
 * @Author ji
 * @Date 2019/11/15 14:49
 * @Version 1.0
 */
public class User implements Serializable {
    private  String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
