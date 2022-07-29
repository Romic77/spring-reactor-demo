package com.reactor.demo.domain.entity;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "article")
public class Article {

    @Id
    private String id;
    private String title;
    private String content;
    private String author;
}