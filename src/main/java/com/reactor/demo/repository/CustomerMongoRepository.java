package com.reactor.demo.repository;

import com.reactor.demo.domain.entity.CustomerMongo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author romic
 * @date 2022/7/29
 */
public interface CustomerMongoRepository extends MongoRepository<CustomerMongo, String> {
    List<CustomerMongo> findByFirstName(String firstName);


    CustomerMongo findById(Long id);

}
