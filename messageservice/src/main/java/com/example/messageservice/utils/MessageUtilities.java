package com.example.messageservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.messageservice.dto.MessageDto;
import com.example.messageservice.model.Message;


public class MessageUtilities {
		public static MessageDto convertToMessageDto(Message msg) {
		MessageDto msgdto = new MessageDto();
		msgdto.setNoteId(msg.getNoteId());
		msgdto.setMessage(msg.getMessage());
		msgdto.setMsgId(msg.getMsgId());
		msgdto.setMessageFrom(msg.getMessageFrom());
		msgdto.setMessageTo(msg.getMessageTo());
		return msgdto;
	}
	public static Message convertToMessage(MessageDto msgdto) {
		Message msg = new Message();
		msg.setNoteId(msgdto.getNoteId());
		msg.setMessage(msgdto.getMessage());
		msg.setMessageFrom(msgdto.getMessageFrom());
		msg.setMessageTo(msgdto.getMessageTo());
		msg.setMsgId(msgdto.getMsgId());
		
		return msg;
	}
	public static List<MessageDto> convertToNotesDtoList(List<Message> list){
		List<MessageDto> dtolist = new ArrayList<MessageDto>();
		for(Message msg : list) 
			dtolist.add(convertToMessageDto(msg));
		return dtolist;
	}

}
