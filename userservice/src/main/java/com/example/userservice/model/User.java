package com.example.userservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="user")
@Data
public class User {
	@Id
	private String author;
	
	private String password;
	
	private String email;
	
	private String mobile;
	
}
