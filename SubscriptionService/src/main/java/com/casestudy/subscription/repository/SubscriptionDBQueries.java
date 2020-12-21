package com.casestudy.subscription.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.casestudy.subscription.entity.Subscription;

@Component
public class SubscriptionDBQueries {
	

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	public List<Subscription> findByBookIdAndSubscriberName(Subscription subscription){
		return subscriptionRepository.findByBookIdAndSubscriberName(subscription.getBookId(), subscription.getSubscriberName());
	}
	
	public boolean checkSubscriptionAlreadyExistInDBWithoutReturn(Subscription subscription) {
		if(subscriptionRepository.findByBookIdAndSubscriberName(subscription.getBookId(), subscription.getSubscriberName()).size()==0){return true;}
		return false;
	}
	
	

}
