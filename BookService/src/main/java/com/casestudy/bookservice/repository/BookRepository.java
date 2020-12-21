package com.casestudy.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book,String> {

}
