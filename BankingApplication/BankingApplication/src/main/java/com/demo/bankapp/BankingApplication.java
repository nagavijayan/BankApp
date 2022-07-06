package com.demo.bankapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BankingApplication {
	
	 private final Logger log = 
			     LoggerFactory.getLogger(BankingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	
	

}
