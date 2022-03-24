package com.siqueira76.demo.repos;

import java.util.List;

import com.siqueira76.demo.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findAll();
}
