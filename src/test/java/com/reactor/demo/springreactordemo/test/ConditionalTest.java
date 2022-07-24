package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Flux;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class ConditionalTest {
    public static void main(String[] args) {
        //takeUtil 提交元素直到断言条件返回true
        Flux.range(1, 100).takeUntil(i -> i == 10).subscribe(System.out::println);

        //takeWhile 当元素满足条件才取出来
        Flux.range(1, 100).takeWhile(i -> i <= 10).subscribe(System.out::println);

        System.out.println("---------------------------");


        //丢弃原始数据流中的元素,直到条件返回true
        //丢弃元素直到i=90
        Flux.range(1, 100).skipUntil(i -> i == 90).subscribe(System.out::println);

        //丢弃原始数据流的元素, 单元素满足条件才取出来
        //丢弃 i<=90 元素
        Flux.range(1, 100).skipWhile(i -> i <= 90).subscribe(System.out::println);
    }

}
