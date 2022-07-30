package com.reactor.demo.controller;

import com.reactor.demo.domain.entity.Article;
import com.reactor.demo.service.ReactiveRedisArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author romic
 * @date 2022/7/29
 */
@RestController
@RequestMapping("/redis")
public class CustomerRedisController {
    @Autowired
    private ReactiveRedisArticleService reactiveRedisArticleService;

    @PostMapping("/save")
    public Mono<Boolean> save(@RequestBody Article article) {
        return reactiveRedisArticleService.save(article);
    }

    @GetMapping("/list")
    public Flux<Article> list() {
        return reactiveRedisArticleService.findAll();
    }
}
