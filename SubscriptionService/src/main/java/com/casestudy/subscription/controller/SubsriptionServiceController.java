package com.casestudy.subscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.subscription.entity.Subscription;
import com.casestudy.subscription.model.Book;
import com.casestudy.subscription.service.SubscriptionService;

@RestController
public class SubsriptionServiceController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@GetMapping(value="/subscription",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Subscription> getAllSubscriptions(){
		return subscriptionService.getAllSubscriptions();
	}
		
	@PostMapping(value="/subscription/subscribe",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String subscribeBook(@RequestBody Subscription subscription) {
		return subscriptionService.subscribeBook(subscription);
	}
	
	@PostMapping(value="/subscription/returns",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String returnBook(@RequestBody Subscription subscription) {
		return subscriptionService.returnBook(subscription);
	}
	


}
