package com.jiguang.spring.cloud.alibaba.provider.controller;

import com.jiguang.spring.cloud.alibaba.provider.serivice.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ji
 * @Date 2019/11/9 19:37
 * @Version 1.0
 */
@RefreshScope
@RestController
public class TestEchoController {
    @Autowired
    private EchoService echoService;

    @Value("${user.name}")
    private  String username;

    @GetMapping(value = "/feign/echo/{string}")
    public  String echo(@PathVariable("string") String string){
        return  echoService.echo(string);
    }
    @GetMapping(value = "/lb")
    public String lb() {
        return echoService.lb();
    }

    @GetMapping(value = "/config")
    public  String config(){
        return  echoService.echo(username);
    }
}
