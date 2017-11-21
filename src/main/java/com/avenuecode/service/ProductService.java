package com.avenuecode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenuecode.model.Product;
import com.avenuecode.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	/**
	 * save a product
	 * @param product
	 * @return product
	 */
	public Product save(Product product) {
		return 	this.repository.save(product);
	}
	/**
	 * returns all products in database
	 * @return Iterable<Product>
	 */
	public List<Product> findAll(){
		return (List<Product>) this.repository.findAll();
	}
	/**
	 * returns all products in database with relationship
	 * @return Iterable<Product>
	 */
	public List<Product> findAllWithRelationship(){
		return (List<Product>) this.repository.findAllProductWithChildren();
	}
	/**
	 * find a product throught id
	 * @param id
	 * @return
	 */
	public Product findById(long id) {
		return this.repository.findOne(id);
	}
	/**
	 * find a product throught id with relationship
	 * @param id
	 * @return
	 */
	public Product findByIdWithRelationShip(long id) {
		return this.repository.findProductWithChildrenById(id);
	}
	
	public List<Product> findChildProductByProductId(long id){
		return this.repository.findChildProductByProductId(id);
	}
	/**
	 * delete a product
	 * @param product
	 */
	public void delete(Product product) {
		this.repository.delete(product);
	}
	
	
	
}
