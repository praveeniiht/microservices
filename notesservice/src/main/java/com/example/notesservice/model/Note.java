package com.example.notesservice.model;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "note")
@Data
@NoArgsConstructor
public class Note {
	
	@Id
	private int id;
	
	private String title;
	
	private String author;
	
	private String description;
	
	private String status;
	
	private int noOfLikes;
	
	

}
