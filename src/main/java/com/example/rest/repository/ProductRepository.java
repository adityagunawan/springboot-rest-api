package com.example.rest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
}
