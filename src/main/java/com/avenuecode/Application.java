package com.avenuecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avenuecode.model.Image;
import com.avenuecode.model.Product;
import com.avenuecode.service.ImageService;
import com.avenuecode.service.ProductService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageService imageService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Product pai = new Product("Chuck");

		Product product1 = new Product("Sergey");

		product1.setProduct(pai);
		
		Image image = new Image();
		image.setProd(product1);
		
		this.productService.save(product1);
		this.imageService.save(image);
	}
}
