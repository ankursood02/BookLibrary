package com.casestudy.subscription.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.subscription.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,String>{
	
	
	List<Subscription> findByBookIdAndSubscriberName(String bookId, String subscriberName);
	
}




