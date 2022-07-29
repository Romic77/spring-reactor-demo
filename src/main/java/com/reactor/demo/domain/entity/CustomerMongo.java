package com.reactor.demo.domain.entity;

import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CustomerMongo {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

}