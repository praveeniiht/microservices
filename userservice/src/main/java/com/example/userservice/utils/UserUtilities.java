package com.example.userservice.utils;

import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;

public class UserUtilities {
	
	public static  UserDto convertToUserDto(User user) {
		UserDto usr = new UserDto();
		usr.setAuthor(user.getAuthor());
		usr.setPassword(user.getPassword());
		usr.setEmail("praveen@gmail.com");
		return usr;
	}
	
	public static User converToUser(UserDto user) {
		User usr = new User();
		usr.setAuthor(user.getAuthor());
		usr.setPassword(user.getPassword());
		usr.setEmail(user.getEmail());
		return usr;
	}

}
