package com.avenuecode.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.avenuecode.model.Product;
import com.avenuecode.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

	@Autowired
	private ProductService productService;
    @Test
    public void contextIsLoaded() throws Exception {
    		
    		assertThat(productService).isNotNull();
    }
    
    @Test
    public void saveProduct() {
    		Product product = new Product();
    		product.setName("Clothe");
    		product.setDescription("T-shirt");
    		
    		Product saved = productService.save(product);
    		assertThat(saved).isNotNull();
    		assertThat(saved.getName()).isEqualTo("Clothe");
    		assertThat(saved.getDescription()).isEqualTo("T-shirt");
    }
    @Test
    public void saveProductWithChildren() {
		Product product = new Product();
		product.setName("Clothe");
		product.setDescription("T-shirt");
		
		Product children1 = new Product();
		children1.setName("Women Clothes");
		children1.setDescription("Women T-Shirt");
		children1.setProduct(product);
		
		productService.save(children1);
		Product saved = productService.findById(children1.getId());
		assertThat(saved).isNotNull();
		assertThat(saved.getName()).isEqualTo("Women Clothes");
		assertThat(saved.getDescription()).isEqualTo("Women T-Shirt");
		assertThat(saved.getProduct().getChildProducts()).hasSize(1);
    }
}
