package com.casestudy.bookservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.casestudy.bookservice.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceControllerTest {
	
	@InjectMocks
	private BookService bookService;
	
	@InjectMocks
	private BookServiceController bookServiceController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookServiceController).build();
	}
	
	
	@Test
	void getBookShouldReturnStatusIsOk() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/101").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
	
		Mockito.verify(bookService, Mockito.times(1)).getBookById("101");
	}
	
	
	@Test
	void getAllBooksShouldReturnStatusIsOk() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
	
		Mockito.verify(bookService, Mockito.times(1)).getAllBooks();
	}

}
