package com.example.userservice.dto;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserDto {
	
	@NotNull
	@Length(min=5,max=15)
	private String author;
	@NotNull
	@Length(min=5, max=15)
	private String password;
	@Email
	private String email;
	private String mobile;
	
}
