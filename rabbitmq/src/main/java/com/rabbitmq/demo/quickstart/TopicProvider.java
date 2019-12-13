package com.rabbitmq.demo.quickstart;

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
public class TopicProvider {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.6.101");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        //3.从连接工作获取连接
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection("生产者");
            //4.从连接中创建通道
            channel = connection.createChannel();

            String queueName="test_topic_queue";
            String exchangeName="test_topic_exchange";
            String exchangeType="topic";
            String routeKey="user.save";
            String routeKey1="user.insert.jiji";
            String routeKey2="user.del";
            String routeKey3="user.update";


            /*
             * 5.声明（创建）队列,
             * 如果队列不存在才会创建
             * RabbitMQ不允许声明两个队列名相同，属性不同的队列，否则会报错
             **/
            channel.queueDeclare(queueName, false, false, false, null);
            //6.发送消息
            String message = "Hello RabbitMQ";
            channel.basicPublish(exchangeName,routeKey1,null,message.getBytes());
            channel.basicPublish(exchangeName,routeKey2,null,message.getBytes());
            channel.basicPublish(exchangeName,routeKey3,null,message.getBytes());
            System.out.println("消息已发送");

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //7.关闭通道
            if(channel !=null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            //8.关闭连接
            if(connection !=null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
