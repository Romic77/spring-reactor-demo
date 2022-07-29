package com.reactor.demo.controller;

import com.reactor.demo.domain.entity.CustomerMongo;
import com.reactor.demo.repository.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author romic
 * @date 2022/7/29
 */
@RestController
@RequestMapping("/mongo")
public class CustomerMongoController {
    @Autowired
    private CustomerMongoRepository customerMongoRepository;

    @PostMapping("/save")
    public CustomerMongo save() {
        CustomerMongo customerMongo = new CustomerMongo();
        customerMongo.setFirstName("chen");
        customerMongo.setLastName("qi");
        customerMongo.setAge(30);
        customerMongo.setId(UUID.randomUUID().toString());
        return customerMongoRepository.save(customerMongo);
    }

    @GetMapping("/list")
    public List<CustomerMongo> list() {
        return customerMongoRepository.findAll();
    }
}
