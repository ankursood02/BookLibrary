package com.casestudy.bookservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.casestudy.bookservice.entity.Book;
import com.casestudy.bookservice.repository.BookRepository;

@Service
public class BookService {

	private final Producer producer;
	private static Logger log = LoggerFactory.getLogger(BookService.class);

	@Autowired
	public BookService(Producer producer) {
		this.producer = producer;
	}

	@Autowired
	private BookRepository bookrepository;

	public Book getBookById(String bookId) {
		return bookrepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book with ID "+ bookId +" is not found"));
	}

	public List<Book> getAllBooks() {
		return bookrepository.findAll();
	}

	public String saveAllBooks(List<Book> books) {
		bookrepository.saveAll(books);
		return "All Books Saved Successfully";
	}

	public Book updateBooksAvailabilty(String bookId,int incremental_count) {

		Book book = bookrepository.findById(bookId).get();
				
		if(incremental_count<0) {
			
			int availableCopies = book.getAvailableCopies() - 1;
			if (availableCopies <= book.getTotalCopies())
				book.setCopiesAvailable(availableCopies);
			bookrepository.save(book);
			return book;
			
		}else {
			
			int availableCopies = book.getAvailableCopies() + 1;
			if (availableCopies <= book.getTotalCopies())
				book.setCopiesAvailable(availableCopies);
			bookrepository.save(book);
			if(availableCopies==1) {
				log.debug("**************Sending message**********");
				this.producer.sendMessage(book.getBookId());
			}
			return book;
			
		}

	}	

}
