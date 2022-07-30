package com.reactor.demo.service;

import com.reactor.demo.domain.entity.Article;
import com.reactor.demo.repository.ArticleReactiveRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author romic
 * @date 2022-07-30
 * @description
 */
@Service
public class ReactiveRedisArticleService implements ArticleReactiveRedisRepository {
    @Autowired
    private ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    public static final String REDIS_KEY = "Article:";

    @Override
    public Mono<Boolean> save(Article article) {
        return reactiveRedisTemplate.opsForValue().set(REDIS_KEY + article.getId(), article);
    }

    @Override
    public Mono<Boolean> update(Article article) {
        return reactiveRedisTemplate.opsForValue().set(REDIS_KEY + article.getId(), article);
    }

    @Override
    public Mono<Boolean> deleteById(String id) {
        return reactiveRedisTemplate.opsForValue().delete(REDIS_KEY + id);
    }

    @Override
    public Mono<Article> findArticleById(String id) {
        return reactiveRedisTemplate.opsForValue().get(REDIS_KEY + id).map(object -> (Article) object);
    }

    @Override
    public Flux<Article> findAll() {
        return reactiveRedisTemplate.keys(REDIS_KEY + "*").flatMap(key -> reactiveRedisTemplate.opsForValue().get(key).map(object -> (Article) object));
    }

}
