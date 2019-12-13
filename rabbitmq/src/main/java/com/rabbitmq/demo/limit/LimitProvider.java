package com.rabbitmq.demo.limit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-03 00:31
 * @Version 1.0
 **/
public class LimitProvider {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建factory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.6.101");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //3.从连接工作获取连接
        Connection connection = connectionFactory.newConnection("生产者");
        //4.从连接中创建通道
        Channel channel = connection.createChannel();
        //指定消息投递模式:消息确认模式
        channel.confirmSelect();
        String queueName = "test_qosQueue";
        String exchangeName = "test_qosExchange";
        String routeKey = "qos.del";
        String routeKey2 = "qos.save";
        //return

        //发送消息
        String msg = "hello qos";
        for (int i = 0; i <5 ; i++) {
            channel.basicPublish(exchangeName, routeKey2, true, null, msg.getBytes());
        }
    }
}

