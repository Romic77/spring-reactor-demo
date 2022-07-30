package com.reactor.demo.repository;

import com.reactor.demo.domain.entity.Article;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author romic
 * @date 2022-07-30
 * @description
 */
public interface ArticleReactiveRedisRepository {
    Mono<Boolean> save(Article article);

    Mono<Boolean> update(Article article);

    Mono<Boolean> deleteById(String id);

    Mono<Article> findArticleById(String articleId);

    Flux<Article> findAll();
}
