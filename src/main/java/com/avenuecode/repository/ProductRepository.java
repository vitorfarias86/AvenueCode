package com.avenuecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.avenuecode.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	@Query("from Product p LEFT JOIN FETCH p.father LEFT JOIN FETCH p.childImages LEFT JOIN FETCH p.childProducts")
	public List<Product> findAllProductWithChildren();
	
	@Query("from Product p LEFT JOIN FETCH p.father LEFT JOIN FETCH p.childImages LEFT JOIN FETCH p.childProducts WHERE p.id = ?1")
	public Product findProductWithChildrenById(long id);
	
	@Query("SELECT p.childProducts from Product p WHERE p.id = ?1")
	public List<Product> findChildProductByProductId(long id);
	
}
