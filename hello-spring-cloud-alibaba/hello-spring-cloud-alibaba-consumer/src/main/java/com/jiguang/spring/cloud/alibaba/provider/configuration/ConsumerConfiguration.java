package com.jiguang.spring.cloud.alibaba.provider.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ji
 * @Date 2019/11/9 18:37
 * @Version 1.0
 */
@Configuration
public class ConsumerConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
