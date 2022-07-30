package com.reactor.demo.controller;

import com.reactor.demo.config.CustomChannelBinder;
import com.reactor.demo.domain.response.Result;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author romic
 * @date 2022-07-30
 * @description
 */
@RestController
@RequestMapping("/recketmq")
public class RocketMqController {
    // 获取name为output的binding
    @Autowired
    private CustomChannelBinder channelBinder;

    /**
     * 简单的消息发送
     *
     * @param msg
     * @return void
     * @author romic
     * @date 2022-07-30 23:53
     */
    @PostMapping("/sendMsg")
    public Result sendMsg(@RequestBody String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).build();
        return Result.success(channelBinder.sendChannel().send(message));
    }


    /**
     * 生产带tag的消息
     * 需要在配置文件中配置:spring.cloud.stream.rocketrmq.bindings.消费者名称.consumer.subscription=配置tag
     *
     * @param msg
     * @return void
     * @author romic
     * @date 2022-07-30 23:53
     */
    @PostMapping("/sendTagMsg")
    public Result sendTagMsg(@RequestBody String msg) {
        Message<String> message = MessageBuilder.withPayload(msg).setHeader(MessageConst.PROPERTY_TAGS, "myTag1").build();
        return Result.success(channelBinder.sendChannel().send(message));
    }
}
