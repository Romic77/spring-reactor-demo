package com.reactor.demo.springreactordemo.test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
public class TransformingTest {

    public static void main(String[] args) {
        //buffer  把当前流中的元素收集到指定的集合中,并把集合对象作为流中的新元素.
        //创建50个元素,将50个元素的流构建成集合,每个集合包含10个元素
        Flux.range(1, 50).buffer(10).subscribe(System.out::println);

        //bufferUtil 收集元素直到predicate返回true
        //每次收集2个元素
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);

        //bufferWhile 收集predicate返回true的元素
        // 收集1-10流元素中,元素为偶数的集合
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        //对流进行操作
        Flux.just(1, 5).flatMap(x -> Mono.just(x * x)).subscribe(System.out::println);

        //取出流的元素,对元素进行操作
        Flux.just(1, 5).map(x -> x * x).subscribe(System.out::println);


        //window类似buffer, 对1-5元素进行收集,每个集合2个元素
        Flux.range(1, 5).window(2).toIterable().forEach(w -> {
            w.subscribe(System.out::println);
            System.out.println("--");
        });
    }
}
