package com.rabbitmq.spring.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
class   DemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public  void  test1()  throws  Exception{
        rabbitAdmin.declareExchange(new DirectExchange("test.direct",false,false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic",false,false));
        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout",false,false));

        rabbitAdmin.declareQueue(new Queue("test.direct.queue",false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue",false));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue",false));

        rabbitAdmin.declareBinding( new Binding("test.direct.queue",
                Binding.DestinationType.QUEUE,
                "test.direct",
                "direct",
                new HashMap<>()
                ));

        rabbitAdmin.declareBinding(
                BindingBuilder
                        .bind(new Queue("test.topic.queue", false))		//直接创建队列
                        .to(new TopicExchange("test.topic", false, false))	//直接创建交换机 建立关联关系
                        .with("user.#"));	//指定路由Key


        rabbitAdmin.declareBinding(
                BindingBuilder
                        .bind(new Queue("test.fanout.queue", false))
                        .to(new FanoutExchange("test.fanout", false, false)));

        //清空队列数据
        rabbitAdmin.purgeQueue("test.topic.queue", false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        return  rabbitTemplate;
    }

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Test
    public  void testSendMessage(){
        //创建消息
        MessageProperties messageProperties=new MessageProperties();
        messageProperties.getHeaders().put("desc", "信息描述");
        messageProperties.getHeaders().put("type", "自定义消息类型");
        Message  message= new Message("hello Rabbit".getBytes(), messageProperties);
        //
        rabbitTemplate.convertAndSend("topic001", "spring.amqp",message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                System.out.println("-----------添加额外的配置");
                message.getMessageProperties().getHeaders().put("desc", "修改后的配置");
                message.getMessageProperties().getHeaders().put("type", "修改后的消息类型");

                return message;
            }
        });
    }

    @Test
    public  void testSendMessage2(){
        //创建消息
        MessageProperties messageProperties=new MessageProperties();
        messageProperties.setContentType("text/plain");
        messageProperties.getHeaders().put("desc", "信息描述");
        messageProperties.getHeaders().put("type", "自定义消息类型");
        //
        Message message= new Message("send !!!".getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("topic001", "spring.amqp","message!!!!topic001");
        rabbitTemplate.convertAndSend("topic002", "rabbit.amqp","message!!!!topic002");
        rabbitTemplate.send("topic001","spring.amqp",message);
    }
}
