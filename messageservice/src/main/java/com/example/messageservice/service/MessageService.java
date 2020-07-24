package com.example.messageservice.service;

import java.util.List;

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;


public interface MessageService {
	public List<MessageDto> findAll();
	public MessageDto addMessage(MessageDto message);
	public MessageDto updateMessage(MessageDto message);
	//public MessageDto deleteMessage(MessageDto message);
	public List<MessageDto> findAllByMessageTo(String messageTo);
}
