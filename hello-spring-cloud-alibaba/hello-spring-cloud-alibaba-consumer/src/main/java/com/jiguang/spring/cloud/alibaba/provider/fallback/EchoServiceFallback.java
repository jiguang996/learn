package com.jiguang.spring.cloud.alibaba.provider.fallback;

import com.jiguang.spring.cloud.alibaba.provider.serivice.EchoService;
import org.springframework.stereotype.Component;

/**
 * @Author ji
 * @Date 2019/11/11 0:55
 * @Version 1.0
 */

@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String string) {
        return "网络有误";
    }

    @Override
    public String lb() {
        return "请联系客服";
    }
}
