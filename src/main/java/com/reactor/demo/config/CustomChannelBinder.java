package com.reactor.demo.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义通道 Binder
 */
public interface CustomChannelBinder {

    /**
     * 发送消息(消息生产者)
     * 绑定配置中的channel名称
     */
    @Output("topic-producer")
    MessageChannel sendChannel();


    /**
     * 接收消息1(消费者1)
     * 绑定配置中的channel名称
     */
    @Input("topic-consumer1")
    MessageChannel testInputChannel1();

    /**
     * 接收消息2(消费者2)
     * 绑定配置中的channel名称
     */
    @Input("topic-consumer2")
    MessageChannel testInputChannel2();
}