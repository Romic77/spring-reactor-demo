package com.reactor.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author romic
 * @date 2022/7/25
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    public Flux<String> index() {
        return Flux.just("hello world");
    }
}
