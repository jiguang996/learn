package com.rabbitmq.demo.returnlistener;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ReturnListener;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-03 00:31
 * @Version 1.0
 **/
public class ReturnProvider {

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
        String queueName = "test_return_queue";
        String exchangeName = "test_return_exchange";
        String routeKey = "return.del";
        String routeKey2 = "retur.save";
        //return
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("--------------handle_return-------");
                System.out.println("replyCode:" + replyCode);
                System.out.println("replyText:" + replyText);
                System.out.println("exchange:" + exchange);
                System.out.println("routingKey:" + routingKey);
                System.out.println("properties:" + properties);
                System.out.println("body:" + new String(body));
            }
        });
        //发送消息
        String msg = "hello confirm";
        channel.basicPublish(exchangeName, routeKey2, true, null, msg.getBytes());

    }
}

