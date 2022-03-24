package com.siqueira76.demo;

import com.siqueira76.demo.models.Order;
import com.siqueira76.demo.models.Product;
import com.siqueira76.demo.repos.CustomerRepo;
import com.siqueira76.demo.repos.OrderRepo;
import com.siqueira76.demo.repos.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
class StreamApiExemplesApplicationTests {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.filter(p -> p.getPrice() > 100)
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of order products belong to category = \"Baby\" ")
	public void exercise2() {
		long startTime = System.currentTimeMillis();
		List<Order> result = orderRepo.findAll();
		List<Order> resultFinal = result
				.stream()
				.filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("baby")))
				.collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
		resultFinal.forEach(p -> log.info(p.toString()));
	}

}
