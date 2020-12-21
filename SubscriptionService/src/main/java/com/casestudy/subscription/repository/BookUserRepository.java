package com.casestudy.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.subscription.model.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser,String>{
}
