package com.example.userservice.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.userservice.dto.NotesDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import static com.example.userservice.utils.UserUtilities.converToUser;
import static com.example.userservice.utils.UserUtilities.convertToUserDto;
@RestController
@RequestMapping("/userservice")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List<UserDto> getAllUsers(){
		return userService.findAll();
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto user){
		HttpStatus status = HttpStatus.CREATED;
		userService.register(user);
		return new ResponseEntity<>(user,status);
	}
	
	@GetMapping("/login")
	public UserDto login(@RequestBody UserDto user) {
		return userService.login(user);
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserDto> update(@RequestBody UserDto user){
		HttpStatus status = HttpStatus.CREATED;
		userService.register(user);
		return new ResponseEntity<>(user,status);
	}
	@GetMapping("/getAllPosts/{author}")
	public ResponseEntity<NotesDto> getAllPostsOfAuthor(@PathVariable("author") String author){
		NotesDto[] response = restTemplate.getForObject
				("http://NOTE-SERVICE/noteservice//search/author/"+author, NotesDto[].class);
		List<NotesDto> notesDto = Arrays.asList(response);
		return new ResponseEntity(notesDto,HttpStatus.OK);
	}
	
	
}
