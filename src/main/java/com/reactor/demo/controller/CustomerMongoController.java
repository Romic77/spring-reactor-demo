package com.reactor.demo.controller;

import com.reactor.demo.domain.entity.Customer;
import com.reactor.demo.repository.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Customer save() {
        Customer customer = new Customer();
        customer.setFirstName("chen");
        customer.setLastName("qi");
        customer.setAge(30);

        return customerMongoRepository.save(customer);
    }
}
