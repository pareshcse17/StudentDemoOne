package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;

@Configuration
public class MultipleMongoConfig {

	public MultipleMongoConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("MultipleMongoConfig constructor ...");
	}
	
	@Primary
	@Bean(name = "primary")
	@ConfigurationProperties(prefix = "spring.data.mongodb.primary")
	public MongoProperties getPrimary() {
		return new MongoProperties();
	}
	
	@Bean(name = "secondary")
	@ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
	public MongoProperties getSecondary() {
		return new MongoProperties();
	}
	
	@Primary
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception{
		return new MongoTemplate(primaryFactory(getPrimary()));
	}

	@Bean(name = "secondaryMongoTemplate")
	public MongoTemplate secondaryMongoTemplate() throws Exception{
		return new MongoTemplate(secondaryFactory(getSecondary()));
	}

	@Primary
	@Bean
	public MongoDatabaseFactory primaryFactory(MongoProperties mongo) throws Exception {
		// TODO Auto-generated method stub
		return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/student_ss");
	}
	
	@Bean
	public MongoDatabaseFactory secondaryFactory(final MongoProperties mongo) throws Exception {
		// TODO Auto-generated method stub
		return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/teacher_DB");
	}
	
}
