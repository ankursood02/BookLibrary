package com.casestudy.bookservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.bookservice.entity.Book;
import com.casestudy.bookservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookServiceController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping(value="/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getBookById(@PathVariable String bookId) {
		return bookService.getBookById(bookId);
	}
	
	
	
	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping(value="/savebooks",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String saveAllBooks(@RequestBody List<Book> books) {
		return bookService.saveAllBooks(books);
	}
	
	@PostMapping(value="/UpdateAvailability/{bookId}/{incremental_count}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Book updateBooksAvailabilty(@PathVariable String bookId,@PathVariable int incremental_count) {
		return bookService.updateBooksAvailabilty(bookId,incremental_count);
	}
}
