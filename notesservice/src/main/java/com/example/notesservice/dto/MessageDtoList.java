package com.example.notesservice.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MessageDtoList implements Serializable{
	
	public List<MessageDto> messages;
	public MessageDtoList() {
		
	}
	public MessageDtoList(List<MessageDto> messages) {
		this.messages=messages;
	}
	
}
