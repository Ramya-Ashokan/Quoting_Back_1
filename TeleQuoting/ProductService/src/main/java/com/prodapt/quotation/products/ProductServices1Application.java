package com.prodapt.quotation.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServices1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductServices1Application.class, args);
	}

}
