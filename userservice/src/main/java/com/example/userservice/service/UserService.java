package com.example.userservice.service;

import java.util.List;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

public interface UserService {
	public List<UserDto> findAll();
	public UserDto register(UserDto user);
	public UserDto login(UserDto user);
	public UserDto update(UserDto user);
	
}
