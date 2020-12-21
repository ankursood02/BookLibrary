package com.casestudy.subscription.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.casestudy.subscription.entity.Subscription;
import com.casestudy.subscription.model.Book;
import com.casestudy.subscription.repository.SubscriptionRepository;

public class SubscriptionServiceTest {
	
	@InjectMocks
	private SubscriptionService subscriptionService;
	
	
	@InjectMocks
	private SubscriptionRepository subscriptionRepository;
	
	@InjectMocks
	RestTemplate restTemplate;
	
	private Book book1, book2;
	private List<Book> returedBookList;
	
	private Subscription subscription;
	
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
		
		
		subscription = new Subscription();
		subscription.set_id("1");
		subscription.setBookId("101");
		subscription.setDateSubscribed(LocalDate.now().minusWeeks(3));
		subscription.setDateReturned(LocalDate.now());
	}
	
	@Test
	public void subscribeBookTest() {
		
		String URL="http://BookService/books/"+subscription.getBookId();		
		
		Mockito.when(restTemplate.getForObject(URL, Book.class)).thenReturn(book1);
		
		String message = subscriptionService.subscribeBook(subscription);
		
		assertEquals("Book Subscribed Successfully", message);
	}
	
	
	@Test
	public void returnBookTest() {
		
		String URL="http://BookService/books/"+subscription.getBookId();		
		
		Mockito.when(restTemplate.getForObject(URL, Book.class)).thenReturn(book1);
		
		String message = subscriptionService.returnBook(subscription);
		
		assertEquals("Book Returned Successfully", message);
	}
}
