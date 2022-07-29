package com.reactor.demo.controller;

import com.reactor.demo.domain.entity.Article;
import com.reactor.demo.service.ArticleService;
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
@RequestMapping("/mongo")
public class CustomerMongoController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public Mono<Article> save(@RequestBody Article article) {
        return articleService.save(article);
    }

    @GetMapping("/list")
    public Flux<Article> list() {
        return articleService.findAll();
    }
}
