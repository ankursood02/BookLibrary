package com.casestudy.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.subscription.entity.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser,String>{
}
