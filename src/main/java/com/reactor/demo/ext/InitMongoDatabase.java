package com.reactor.demo.ext;

import cn.hutool.core.lang.UUID;
import com.reactor.demo.domain.entity.Article;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

/**
 * @author romic
 * @date 2022/7/29
 */
@Component
public class InitMongoDatabase {


    @Bean
    CommandLineRunner init(MongoOperations operations) {
        return args -> {
            operations.dropCollection(Article.class);

            operations.insert(new Article(UUID.randomUUID().toString(), "title1", "content1", "author1"));
            operations.insert(new Article(UUID.randomUUID().toString(), "title2", "content2", "author2"));
            operations.findAll(Article.class).forEach(acticle -> {
                System.out.println(acticle.toString());
            });

        };
    }
}
