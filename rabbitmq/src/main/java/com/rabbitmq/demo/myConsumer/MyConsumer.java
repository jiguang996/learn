package com.rabbitmq.demo.myConsumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-03 23:24
 * @Version 1.0
 **/
public class MyConsumer extends DefaultConsumer {
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public MyConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println("------------consume_message-------");
        System.out.println("consumerTag :"+consumerTag);
        System.out.println("envelope :"+envelope);
        System.out.println("properties :"+properties);
        System.out.println("body :"+body);
    }
}
