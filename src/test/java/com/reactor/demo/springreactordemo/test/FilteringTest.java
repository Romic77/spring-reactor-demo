package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class FilteringTest {
    public static void main(String[] args) {
        //1-10元素过滤,只取能被2取余的元素
        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

        System.out.println("---------------------");
        //返回 第一个元素
        Flux.range(1, 10).sampleFirst(Duration.ZERO).subscribe(System.out::println);
        System.out.println("---------------------");

        //返回最后一个元素
        Flux.range(1, 10).last().subscribe(System.out::println);
        System.out.println("---------------------");

        //取出前面10元素
        Flux.range(1, 100).take(10).subscribe(System.out::println);

        //取出后面10元素
        Flux.range(1, 100).takeLast(10).subscribe(System.out::println);
    }
}
