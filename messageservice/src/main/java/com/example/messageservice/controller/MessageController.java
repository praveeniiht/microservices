package com.example.messageservice.controller;

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

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.dto.MessageDtoList;
import com.example.messageservice.model.Message;
import com.example.messageservice.service.MessageService;

@RestController
@RequestMapping("/messageservice")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	
	@GetMapping("/test")
	public String getMessage() {
		return "Message Service working";
	}
	
	@GetMapping("/all")
	public List<MessageDto> findAll(){
		return messageService.findAll();
		
	}
	@PostMapping("/create")
	public MessageDto addMessage(@RequestBody MessageDto message) {
		return messageService.addMessage(message);
	}
	@PostMapping("/update")
	public MessageDto updateMessage(@RequestBody MessageDto message) {
		return messageService.addMessage(message);
	}
	
	@GetMapping("/getMessageTo/{messageTo}")
	public List<MessageDto> findAllByMessageTo(@PathVariable("messageTo") String messageTo){
		
		return messageService.findAllByMessageTo(messageTo);
	}
}
