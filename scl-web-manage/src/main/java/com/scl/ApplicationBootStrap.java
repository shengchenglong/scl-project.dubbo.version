package com.scl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ApplicationBootStrap{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBootStrap.class, args);
	}

}
