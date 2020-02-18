package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import com.example.rest.model.Product;

public interface ProductService {
	
	List<Product> getAll();

	Optional<Product> getById(Long id);

	Product save(Product product);

	void deleteById(Long id);

}
