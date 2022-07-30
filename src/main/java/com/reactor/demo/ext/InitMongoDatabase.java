package com.reactor.demo.ext;

import cn.hutool.core.lang.UUID;
import com.reactor.demo.domain.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author romic
 * @date 2022/7/29
 */
@Component
public class InitMongoDatabase implements CommandLineRunner {
    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        reactiveMongoTemplate.dropCollection(Article.class);
        reactiveMongoTemplate.insert(new Article(UUID.randomUUID().toString(), "title1", "content1", "author1"));
        reactiveMongoTemplate.insert(new Article(UUID.randomUUID().toString(), "title2", "content2", "author2"));

        reactiveMongoTemplate.findAll(Article.class).toStream().forEach(acticle -> {
            System.out.println(acticle.toString());
        });
    }
}
