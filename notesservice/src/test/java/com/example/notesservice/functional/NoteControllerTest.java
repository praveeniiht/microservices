package com.example.notesservice.functional;

import static com.example.utils.MasterData.toJson;
import static com.example.utils.TestUtils.businessTestFile;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.yakshaAssert;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.notesservice.controller.NoteController;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.service.NoteService;
import com.example.utils.MasterData;



@WebMvcTest(NoteController.class)
//@RunWith(SpringRunner.class)
class NoteControllerTest {
	
	
	  @Autowired private MockMvc mockMvc;
	  
	  @MockBean private NoteService noteService;
	  
	  
	  @Test void testFindAll() throws Exception {
	  
	  List<NotesDto> list = new ArrayList<NotesDto>();
	  list.add(MasterData.getNotesDto());
	  Mockito.when(noteService.findAll()).thenReturn(list);
	  
	  RequestBuilder requestBuilder =
	  MockMvcRequestBuilders.get("/noteservice/all")
	  .content(MasterData.asJsonString(MasterData.getNotesDto()))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	  yakshaAssert(currentTest(), (result.getResponse().getStatus() ==
	  HttpStatus.OK.value() ? "true" : "false"), businessTestFile);
	  
	  
	  }
	  
	  @Test void testAddNote() throws Exception { NotesDto notesdto =
	  com.example.utils.MasterData.getNotesDto();
	  Mockito.when(noteService.addNote(notesdto)) .thenReturn(notesdto);
	  
	  RequestBuilder requestBuilder =
	  MockMvcRequestBuilders.post("/noteserivce/add")
	  .content(com.example.utils.MasterData.asJsonString(notesdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	  
	  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
	  false,businessTestFile);
	  
	  }
	  
	  @Test void testDeleteNote() throws Exception{ NotesDto notesdto =
	  com.example.utils.MasterData.getNotesDto();
	  Mockito.when(noteService.addNote(notesdto)) .thenReturn(notesdto);
	  
	  RequestBuilder requestBuilder =
	  MockMvcRequestBuilders.post("/noteserivce/add")
	  .content(com.example.utils.MasterData.asJsonString(notesdto))
	  .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON);
	  
	  MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	  yakshaAssert(currentTest(),result.getResponse().getStatus()==200? true :
	  false,businessTestFile);
	  
	  }
	  
		/*
		 * @Test void testFindAllByStatus() throws Exception { NotesDto notesdto =
		 * com.example.utils.MasterData.getNotesDto(); NotesDto note1 =
		 * com.example.utils.MasterData.getNotesDto(); NotesDto note2 =
		 * com.example.utils.MasterData.getNotesDto(); List<NotesDto> list = new
		 * ArrayList<NotesDto>(); list.add(note1); list.add(note2);
		 * 
		 * Mockito.when(noteService.findAllByStatus("Done")).thenReturn(list);
		 * 
		 * ResultActions actions =
		 * mockMvc.perform(get("/noteservice/Done").contentType(MediaType.
		 * APPLICATION_JSON)) .andDo(print()).andExpect(status().isOk())
		 * .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		 * .andExpect(jsonPath("$[0].status",
		 * is("Done"))).andExpect(jsonPath("$[1].status", is("Done")));
		 * 
		 * yakshaAssert(currentTest(), actions != null ? true : false,
		 * businessTestFile);
		 * 
		 * }
		 */
	 
}
