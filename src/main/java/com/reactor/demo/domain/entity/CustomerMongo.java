package com.reactor.demo.domain.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class CustomerMongo {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

}