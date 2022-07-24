package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class UtilityTest {

    public static void main(String[] args) {
        //subscribe 添加响应的订阅逻辑 指定需要处理的消息类型
        Mono.just(100).concatWith(Mono.error(new IllegalArgumentException())).onErrorReturn(501).subscribe(System.out::println, System.err::println);

        //超时响应异常
        Mono.just(100).timeout(Duration.ofMillis(5)).onErrorReturn(500).subscribe(System.out::println);

        //操作元素在接到下一个元素之前一直阻塞
        Mono.just(100).block(Duration.ofMillis(5));

        Mono.just(100).log().subscribe(System.out::println);
    }
}
