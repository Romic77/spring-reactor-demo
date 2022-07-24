package com.reactor.demo.springreactordemo.test;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author romic
 * @date 2022-07-24
 * @description
 */
@RestController
public class FluxTest {

    public static void main(String[] args) {
       /* //静态创建flux
        Flux.just("hello", "world").subscribe(System.out::println);

        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);

        Flux.empty().subscribe(System.out::println);

        Flux.range(1, 5).subscribe(System.out::println);*/

        //使用的是synchronousSink 同步组件
        Flux.generate(synchronousSink -> {
            synchronousSink.next("hello");
            synchronousSink.complete();
        }).subscribe(System.out::println);


        //使用的是fluxSink 组件(支持同步和异步的消息产生方式)
        Flux.create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);
                fluxSink.complete();
            }
        }).subscribe(System.out::println);

    }
}
