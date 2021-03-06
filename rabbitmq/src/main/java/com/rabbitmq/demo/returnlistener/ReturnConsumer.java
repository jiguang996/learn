package com.rabbitmq.demo.returnlistener;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-03 00:32
 * @Version 1.0
 **/
public class ReturnConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.6.101");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        //3.从连接工厂获取连接
        Connection connection = null;
        Channel channel = null;
        connection = connectionFactory.newConnection("消费者");
        //4.从连接中获取通道
        channel = connection.createChannel();
        String queueName="test_return_queue";
        String exchangeName="test_return_exchange";
        String routeKey="return.*";
        //5.声明（创建）队列
        channel.exchangeDeclare(exchangeName, "topic",true,false,null );
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routeKey);
        //6.定义收到消息后的回调
        DeliverCallback callback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("收到消息："+new String(message.getBody()));
            }
        };
        //7.监听队列
        channel.basicConsume(queueName, true, callback, new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
            }
        });
    }
}