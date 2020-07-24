package com.example.notesservice.controller;

import static com.example.notesservice.utils.NotesUtilities.convertToNotesDtoList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.notesservice.dto.MessageDto;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;

@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public ResponseEntity<List<NotesDto>> findAll(){
		 HttpStatus httpStatus = HttpStatus.OK; 
		 List<NotesDto> dtolist= noteService.findAll(); 
		 return new ResponseEntity<>(dtolist,httpStatus);
	}
	
	@PostMapping("/add")
	public ResponseEntity<NotesDto> addNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.CREATED;
    	NotesDto saved = noteService.addNote(note);
        return new ResponseEntity<>(saved, status);
    }
	@PostMapping("/update")
	public ResponseEntity<NotesDto> updateNoteTitle(@RequestBody NotesDto notedto){
		HttpStatus status = HttpStatus.CREATED;
    	NotesDto saved = noteService.addNote(notedto);
        return new ResponseEntity<>(saved, status);
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<NotesDto> deleteNote(@RequestBody NotesDto note){
		HttpStatus status = HttpStatus.OK;
		NotesDto notedto = noteService.deleteNote(note);
		return new ResponseEntity<>(notedto,status);
	}
	
	@GetMapping("/note/{id}")
	public ResponseEntity<NotesDto> findById(@PathVariable("id") int  id){
		HttpStatus status = HttpStatus.OK;
		NotesDto notesdto=   noteService.findById(id);
		return new ResponseEntity<>(notesdto,status);
	}
	
	@GetMapping("/search/status/{status}")
	public ResponseEntity<List<NotesDto>> findAllByStatus(@PathVariable("status") String status){
		HttpStatus httpStatus = HttpStatus.OK;
		List<NotesDto> dtolist = noteService.findAllByStatus(status);
		return new ResponseEntity<>(dtolist,httpStatus);
	}
	
	@GetMapping("/search/author/{author}")
	public ResponseEntity<List<NotesDto>> findAllByAuthor(@PathVariable("author") String author){
		HttpStatus httpStatus = HttpStatus.OK;
		List<NotesDto> dtolist = noteService.findAllByAuthor(author);
		return new ResponseEntity<>(dtolist,httpStatus);
	}
	@GetMapping("/search/title/{title}")
	public ResponseEntity<List<NotesDto>> findAllByTitle(@PathVariable("title") String title){
		HttpStatus httpStatus = HttpStatus.OK;
		List<NotesDto> dtolist = noteService.findAllByTitle(title);
		return new ResponseEntity<>(dtolist,httpStatus);
	}
	@GetMapping("/getAllHelpPosts/{toAuthor}")
	public ResponseEntity<List<MessageDto>> getAllHelpPosts(@PathVariable("toAuthor") String toAuthor){
				
		HttpStatus status = HttpStatus.OK;				
		ResponseEntity<MessageDto[]> response =
				restTemplate.getForEntity
				("http://MESSAGE-SERVICE/messageservice/all",MessageDto[].class);
				MessageDto[] messages = response.getBody();
				List<MessageDto> messageList= new ArrayList<>();
				messageList = Arrays.asList(messages);
				List<MessageDto> msgLists = messageList.stream()
							.filter(n->n.getMessageTo().equals(toAuthor))		
							.collect(Collectors.toList());
					
				return new ResponseEntity(msgLists,status);
		}
	
}
