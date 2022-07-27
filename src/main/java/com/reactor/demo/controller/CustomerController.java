package com.reactor.demo.controller;

import com.reactor.demo.dao.CustomerRepository;
import com.reactor.demo.domain.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author romic
 * @date 2022-07-27
 * @description
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/address")
    public List<Customer> address(String address) {
        List<Customer> customers = customerRepository.findAddress(address);
        return customers;
    }
}
