package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Flux;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class MathematicalTest {
    public static void main(String[] args) {
        //concat 合并不同的flux的数据,采用顺序的方式
        Flux.concat(Flux.just("a"), Flux.just("b")).subscribe(System.out::println);

        //count 统计flux中的所有元素个数
        Flux.concat(Flux.just("a"), Flux.just("b")).count().subscribe(System.out::println);

        //reduce 对所有元素进行函数操作,返回Mono序列
        Flux.range(1, 10).reduce(Integer::sum).subscribe(System.out::println);


        //5 1 2 3 4 5 6 7 8 9 10
        Flux.range(1, 10).reduceWith(() -> 5, Integer::sum).subscribe(System.out::println);
    }
}
