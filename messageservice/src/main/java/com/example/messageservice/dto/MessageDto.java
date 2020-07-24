package com.example.messageservice.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDto implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
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
