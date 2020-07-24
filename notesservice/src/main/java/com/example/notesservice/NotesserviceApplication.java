package com.example.notesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication(scanBasePackages = "com.example.notesservice")
@EnableMongoRepositories(basePackages = "com.example.notesservice.repo")
@EntityScan(basePackages = "com.example.notesservice.model")
@EnableEurekaClient
public class NotesserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesserviceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
