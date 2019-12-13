package com.rabbitmq.demo.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
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
public class ConfirmProvider {

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
        Connection connection = null;
        Channel channel = null;
        connection = connectionFactory.newConnection("生产者");
        //4.从连接中创建通道
        channel = connection.createChannel();
        //指定消息投递模式:消息确认模式
        channel.confirmSelect();
        String queueName = "test_confirm_queue";
        String exchangeName = "test_confirm_exchange";
        String exchangeType = "confirm";
        String routeKey = "confirm.save";
        //发送消息
        String msg = "hello confirm";
        channel.basicPublish(exchangeName, routeKey, null, msg.getBytes());
        //确认监听
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("-------ack-------");
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("-------no ack-------");
            }
        });
    }
}

