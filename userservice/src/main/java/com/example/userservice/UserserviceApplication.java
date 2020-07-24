package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
@SpringBootApplication(scanBasePackages="com.example.userservice")
@EnableMongoRepositories(basePackages ="com.example.userservice.repo")
@EntityScan("com.example.userservice.model")
@EnableEurekaClient
public class UserserviceApplication {
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	
}
