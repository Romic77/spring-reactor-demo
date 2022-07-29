package com.reactor.demo.repository;

import com.reactor.demo.domain.entity.Customer;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author romic
 * @date 2022/7/29
 */
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {
    List<Customer> findByFirstName(String firstName);


    Customer findById(Long id);

}
