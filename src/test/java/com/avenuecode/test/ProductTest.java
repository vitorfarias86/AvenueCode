package com.avenuecode.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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
		product.setId(1L);
		product.setName("Cloth");
		product.setDescription("T-shirt");

		Product children1 = new Product();
		children1.setName("Women Clothes");
		children1.setDescription("Women T-Shirt");
		children1.setFather(product);

		productService.save(children1);
		Product saved = productService.findByIdWithRelationShip(children1.getId());
		assertThat(saved).isNotNull();
		assertThat(saved.getName()).isEqualTo("Women Clothes");
		assertThat(saved.getDescription()).isEqualTo("Women T-Shirt");
		assertThat(saved.getFather().getChildProducts()).hasSize(1);
	}
	
	@Test
	public void findChildProductByProductId() {
		
		List<Product> products = productService.findChildProductByProductId(1L);
		assertThat(products).hasSize(1);
	}

}
