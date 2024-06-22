package com.cardealer.macqueens;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = "com.cardealer")
public class MacqueensApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacqueensApplication.class, args);
	}

}
