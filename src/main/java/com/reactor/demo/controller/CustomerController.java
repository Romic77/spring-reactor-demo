package com.reactor.demo.controller;

import com.reactor.demo.domain.entity.Customer;
import com.reactor.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return customerRepository.findAddress(address);
    }

    @GetMapping("/withFirstNameAndAddressQuery")
    public Customer withFirstNameAndAddressQuery(String firstName, String address) {
        return customerRepository.withFirstNameAndAddressQuery(firstName, address);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        customerRepository.deleteById(id);
    }


    @PostMapping("/page")
    public Page<Customer> page() {
        return customerRepository.findAll(PageRequest.of(0, 1));
    }
}
