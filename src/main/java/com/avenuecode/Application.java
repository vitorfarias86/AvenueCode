package com.avenuecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public Module datatypeHibernateModule() {
	  return new Hibernate4Module();
	}
}
