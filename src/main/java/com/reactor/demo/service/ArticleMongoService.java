package com.reactor.demo.service;

import com.reactor.demo.domain.entity.Article;
import com.reactor.demo.repository.ArticleReactiveMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@Service
public class ArticleMongoService {
    @Autowired
    private ArticleReactiveMongoRepository articleReactiveMongoRepository;

    public Mono<Article> save(Article article) {
        return articleReactiveMongoRepository.save(article);
    }

    public Mono<Article> findOne(String id) {
        return articleReactiveMongoRepository.findById(id);
    }

    public Flux<Article> findAll() {
        return articleReactiveMongoRepository.findAll();
    }

    public Mono<Void> deleteById(String id) {
        return articleReactiveMongoRepository.deleteById(id);
    }

    public Flux<Article> findByAuthor(String author) {
        Article article = new Article();
        article.setAuthor(author);

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withMatcher(author, startsWith()).withIncludeNullValues();

        Example<Article> example = Example.of(article, matcher);

        Flux<Article> articleFlux = articleReactiveMongoRepository.findAll(example).log("findByAuthor");
        return articleFlux;
    }


}