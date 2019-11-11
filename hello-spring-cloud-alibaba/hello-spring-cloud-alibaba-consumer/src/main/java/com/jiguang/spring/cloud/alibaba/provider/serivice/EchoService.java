package com.jiguang.spring.cloud.alibaba.provider.serivice;

import com.jiguang.spring.cloud.alibaba.provider.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ji
 * @Date 2019/11/9 20:24
 * @Version 1.0
 */
@FeignClient(value = "service-provider" ,fallback = EchoServiceFallback.class)
public interface EchoService {
    @GetMapping(value = "/echo/{string}")
    public  String echo(@PathVariable("string") String string);
    @GetMapping(value = "/lb")
    String lb();
}
