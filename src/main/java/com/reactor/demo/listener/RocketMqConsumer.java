package com.reactor.demo.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RocketMqConsumer {
    
    @StreamListener("topic-consumer1")
    public void receiveMsg(String receiveMsg) {
        System.out.println("topic-consumer1 receive: " + receiveMsg);
    }

    /**
     * 接受指定的tag消息
     *
     * @param receiveMsg
     * @return void
     * @author romic
     * @date 2022-07-31 0:06
     */
    @StreamListener(value = "topic-consumer2", condition = "headers['ROCKET_TAGS'] == 'myTag'")
    public void receiveInput2(String receiveMsg, @Headers Map headers, @Header(name = "ROCKET_TAGS") String name) {
        System.out.println("headers=" + headers);
        System.out.println("name=" + name);
        System.out.println("topic-consumer2 receive: " + receiveMsg);
    }

    /**
     * 全局异常处理
     *
     * @param message
     */
    @StreamListener("errorChannel")
    public void error(Message<?> message) {
        ErrorMessage errorMessage = (ErrorMessage) message;
        System.out.println("Handling ERROR: " + errorMessage);
    }

}