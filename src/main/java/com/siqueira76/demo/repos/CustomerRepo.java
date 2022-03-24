package com.siqueira76.demo.repos;

import java.util.List;

import com.siqueira76.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

    List<Customer> findAll();
}
