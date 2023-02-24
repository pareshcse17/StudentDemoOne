package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.secondary",
		mongoTemplateRef = "secondaryMongoTemplate")
public class SecondaryMongoConfig {

	public SecondaryMongoConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("SecondaryMongoConfig constructor ...");
	}

}
