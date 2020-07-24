package com.example.userservice.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NotesDto {
	
	@NotNull
	private int id;
	@NotNull
	@Length(min=5,max=15)
	private String title;
	@NotNull
	@Length(min=5,max=20)
	private String author;
	@NotNull
	@Length(min=10,max=300)
	private String description;
	@NotNull
	@Length(min=5,max=15)
	private String status;
	private int noOfLikes;

}
