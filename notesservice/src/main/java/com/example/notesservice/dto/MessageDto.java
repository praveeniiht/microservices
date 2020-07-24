package com.example.notesservice.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
@Data
public class MessageDto implements Serializable{
	@NotNull
	private String msgId;
	@NotNull
	@Length(min=3, max=15)
	private String messageFrom;
	
	@NotNull
	@Length(min=3, max=15)
	private String messageTo;
	
	@NotNull
	@Length(min=10, max=300)
	private String message;
	
	@NotNull
	private int NoteId;

}
