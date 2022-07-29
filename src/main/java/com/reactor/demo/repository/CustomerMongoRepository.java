package com.reactor.demo.repository;

import com.reactor.demo.domain.entity.CustomerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author romic
 * @date 2022/7/29
 */
@Service
public interface CustomerMongoRepository extends MongoRepository<CustomerMongo, String> {
    List<CustomerMongo> findByFirstName(String firstName);


    CustomerMongo findById(Long id);

}
