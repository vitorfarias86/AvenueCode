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
	 * @throws IllegalArgumentException if a invalid father id is passed
	 */
	public Product save(Product product) {
		
		// check if product is valid 
		// yes I know I`ve to use hibernate validator... but my time is short now. :(
		if(product == null) {
			throw new IllegalArgumentException("product cannot be null");

		}
		// if product has father
		if(product.getFather() != null) {	
			// if NOT exists
			if (! repository.exists(product.getFather().getId())) {
				throw new IllegalArgumentException("Invalid father id");
			}
		}
		
		return this.repository.save(product);
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
	public Product findByIdWithRelationship(long id) {
		return this.repository.findProductWithChildrenById(id);
	}
	
	public List<Product> findChildProductByProductId(long id){
		return this.repository.findChildProductByProductId(id);
	}
	/**
	 * delete a product
	 * @param product
	 * @return boolean indicating if the product was deleted or not
	 */
	public boolean delete(Long id) {
		
		Product product = this.repository.findOne(id);
		if (product != null) {
			this.repository.delete(product);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
