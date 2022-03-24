package com.siqueira76.demo.repos;

import java.util.List;

import com.siqueira76.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findAll();
}
