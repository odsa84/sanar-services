package com.odsaproject.sanarservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.odsaproject.sanarservices")
public class SanarServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanarServicesApplication.class, args);
	}

}
