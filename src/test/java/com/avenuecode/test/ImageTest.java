package com.avenuecode.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avenuecode.Application;
import com.avenuecode.model.Image;
import com.avenuecode.model.Product;
import com.avenuecode.service.ImageService;
import com.avenuecode.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class ImageTest {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ProductService productService;
	
	private Product product = null;
	private Product invalidProduct = null;
	@Before
	public void setUp() {
		product = new Product();
		product.setName("bah");
		product = productService.save(product);
		
		invalidProduct = new Product();
		invalidProduct.setId(Long.MAX_VALUE); // inexistent id
	}
	@Test
	public void saveImage() {
		Image image = new Image();
		image.setProduct(this.product);
		assertThat(imageService.save(image)).isNotNull();	
	}
	@Test(expected = IllegalArgumentException.class)
	public void saveNullImage() {
		Image image = null;
		imageService.save(image);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void saveImageInvalidProductId() {
		Image image = new Image();
		image.setProduct(invalidProduct);
		imageService.save(image);	
	}
}
