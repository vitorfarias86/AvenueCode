package com.avenuecode.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avenuecode.Application;
import com.avenuecode.model.Product;
import com.avenuecode.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class ProductTest {

	@Autowired
	private ProductService productService;

	@Test
	public void contextIsLoaded() throws Exception {

		assertThat(productService).isNotNull();
	}
	
	@Test
	public void saveProductWithChildren() {
		Product product = new Product();
		product.setName("Cloth");
		product.setDescription("T-shirt");

		product = productService.save(product);
		
		Product children1 = new Product();
		children1.setName("Women Clothes");
		children1.setDescription("Women T-Shirt");
		children1.setFather(product);

		productService.save(children1);
		Product saved = productService.findByIdWithRelationship(product.getId());
		assertThat(saved).isNotNull();
		assertThat(saved.getName()).isEqualTo("Cloth");
		assertThat(saved.getDescription()).isEqualTo("T-shirt");
		assertThat(saved.getFather().getChildProducts()).hasSize(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void savaProductInvalidFatherId() {
		Product product = new Product();
		product.setId(1000L); // not existent id product

		Product children1 = new Product();
		children1.setName("Women Clothes");
		children1.setDescription("Women T-Shirt");
		children1.setFather(product);
		
		productService.save(children1);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void savaNullProduct() {
		Product product = null;

		
		productService.save(product);
		
	}
}
