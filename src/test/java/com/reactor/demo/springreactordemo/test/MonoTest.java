package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class MonoTest {
    public static void main(String[] args) {
        Mono.just("hello world").subscribe(System.out::println);

        Mono.justOrEmpty(Optional.empty()).subscribe(System.out::println);

        Mono.justOrEmpty(Optional.ofNullable("hello")).subscribe(System.out::println);

        Mono.create(monoSink -> {
            monoSink.success("hello");
        }).subscribe(System.out::println);
    }
}