package com.example.messageservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Document(collection = "Messages")
@Data
@NoArgsConstructor
public class Message {
	@Id
	private String msgId;
	private int noteId;
	private String messageFrom;
	private String messageTo;
	private String message;
}
