package com.example.messageservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import java.io.Serializable;
@Data
public class MessageDtoList implements Serializable {
	
	public List<MessageDto> messages;
	
	public MessageDtoList() {
		
	}
	public MessageDtoList(List<MessageDto> messages) {
		this.messages=messages;
	}
	
	
}
