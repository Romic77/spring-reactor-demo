package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class CombiningTest {

    public static void main(String[] args) {
        //then 等到上一个操作完成再做下一个
        Flux.range(1, 10).filter(i ->
                i % 5 == 0
        ).last().then().subscribe(System.out::println);

        //when 多个操作一起完成
        Mono<Integer> last1 = Flux.range(1, 10).filter(i ->
                i % 5 == 0
        ).last();

        Mono<Integer> last2 = Flux.range(1, 10).filter(i ->
                i % 5 == 0
        ).last();

        Mono.when(last1, last2).then(last2).subscribe(System.out::println);

        //startWith 在数据元素序列的开头插入指定元素项目
        Flux.range(1, 10).startWith(1).subscribe(System.out::println);

        System.out.println("-----------------");

        //merge 把多个流合并成一个flux序列

        //每10毫秒生成一个元素,只取3个 然后将2个序列合并
        //merge是按照流的顺序打印元素, 10毫秒生成2个元素 00,11,22
        Flux.merge(Flux.interval(Duration.ofMillis(10)).take(3), Flux.interval(Duration.ofMillis(10)).take(3)).toStream().forEach(System.out::println);

        System.out.println("-----------------");

        //mergeSequential 是按照流的单位进行合并, 先打印一个流,打印完毕了之后再打印第二个流
        //第一个流 1,2,3 第二个流 1,2,3
        Flux.mergeSequential(Flux.interval(Duration.ofMillis(10)).take(3), Flux.interval(Duration.ofMillis(10)).take(3)).toStream().forEach(System.out::println);

        //zipWith 把当前流中的元素与另外的流中的元素 1:1 合并
        Flux.just("a", "b").zipWith(Flux.just("c", "d")).subscribe(System.out::println);

        Flux.just(1, 2).zipWith(Flux.just(3, 4), Integer::sum
        ).subscribe(System.out::println);

    }
}
