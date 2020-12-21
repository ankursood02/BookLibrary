package com.casestudy.bookservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.casestudy.bookservice.entity.Book;
import com.casestudy.bookservice.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@InjectMocks
	private BookService bookService;
	
	@InjectMocks
	private BookRepository bookRepository;
	
	private Book book1, book2;
	private List<Book> returedBookList;
	
	
	@BeforeEach
	public void setup() {
		
		book1 = new Book();
		book1.setBookId("101");
		book1.setAuthor("James Anderson");
		book1.setBookName("What Is Cricket");
		book1.setTotalCopies(10);
		book1.setCopiesAvailable(7);
		
		book2 = new Book();
		book2.setBookId("102");
		book2.setAuthor("Adom Smith");
		book2.setBookName("Life After Death");
		book2.setTotalCopies(10);
		book2.setCopiesAvailable(5);
		
		returedBookList = new ArrayList<>();
		returedBookList.add(book1);
		returedBookList.add(book2);
	}
	
	
	@Test
	public void getBookByIdShouldReturnBook() {
		
		Mockito.when(bookRepository.findById("101")).thenReturn(Optional.ofNullable(book1));
		
		Book returnedBook = bookService.getBookById("101");
		
		assertEquals("101", returnedBook.getBookId());
		Mockito.verify(bookRepository, Mockito.times(1)).findById("101");
	}
	
	
	@Test
	public void getBookByIdShouldThrowException() {
		
		Mockito.when(bookRepository.findById("1111")).thenReturn(Optional.empty());
		
		Throwable exception = assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById("1111"));
		assertEquals("Book with ID 1111 is not found", exception.getMessage());
	}

	
	@Test
	public void getAllBooksShouldReturnAllListOfBooksTest() {
		
		Mockito.when(bookRepository.findAll()).thenReturn(returedBookList);
		
		List<Book> returnedBooks = bookService.getAllBooks();
		
		assertEquals(book1, returnedBooks.get(0));
		Mockito.verify(bookRepository, Mockito.times(0)).findById("101");
		Mockito.verify(bookRepository, Mockito.times(1)).findAll();
	}
	
	
	@Test
	public void saveAllBooksTest() {	
		
		Mockito.when(bookRepository.saveAll(returedBookList)).thenReturn(returedBookList);
		
		String message = bookService.saveAllBooks(returedBookList);
		
		assertEquals(message, "All Books Saved Successfully");
	}
}
	
