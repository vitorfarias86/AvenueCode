package com.avenuecode.repository;

import org.springframework.data.repository.CrudRepository;

import com.avenuecode.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	
}
