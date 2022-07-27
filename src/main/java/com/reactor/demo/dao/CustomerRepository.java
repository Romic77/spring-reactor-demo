package com.reactor.demo.dao;

import com.reactor.demo.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author romic
 * @date 2022-07-27
 * @description
 */
@Service
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where  c.address = :address")
    List<Customer> findAddress(String address);

    Customer findByFirstNameAndAddress(String firstName, String address);

    @Query("select c from Customer c where c.firstName= :firstName and c.address = :address")
    Customer withFirstNameAndAddressQuery(@Param("firstName") String firstName, @Param("address") String address);

    List<Customer> withAddressNamedQuery(String address);

}
