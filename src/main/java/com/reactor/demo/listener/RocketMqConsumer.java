package com.reactor.demo.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class RocketMqConsumer {

    @StreamListener("topic-consumer")
    public void receiveMsg(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }

   /* @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        System.out.println("input2 receive: " + receiveMsg);
    }*/

}