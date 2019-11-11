package com.jiguang.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ji
 * @Date 2019/11/9 17:49
 * @Version 1.0
 */

@RestController
public class EchoController {

    @Value("${server.port}")
    private  String port;
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Provider " + string;
    }

    @GetMapping("/lb")
    public  String  getLb(){
        return "Hello Nacos Provider i am from port: " + port;
    }
}