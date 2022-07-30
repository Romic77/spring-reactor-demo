package com.reactor.demo.service;

import com.reactor.demo.domain.entity.Article;
import com.reactor.demo.repository.ArticleReactiveRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author romic
 * @date 2022-07-30
 * @description
 */
@Repository
public class ReactiveRedisArticleService implements ArticleReactiveRedisRepository {
    @Autowired
    private ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    @Override
    public Mono<Boolean> save(Article article) {
        return reactiveRedisTemplate.opsForValue().set("article:" + article.getId(), article);
    }

    @Override
    public Mono<Boolean> update(Article article) {
        return null;
    }

    @Override
    public Mono<Boolean> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Article> findArticleById(String articleId) {
        return null;
    }

    @Override
    public Flux<Article> findAll() {
        return null;
    }
}
