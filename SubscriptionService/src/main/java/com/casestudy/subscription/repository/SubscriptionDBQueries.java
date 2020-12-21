package com.casestudy.subscription.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.casestudy.subscription.entity.Subscription;
import com.casestudy.subscription.model.BookUser;

@Component
public class SubscriptionDBQueries {
	

	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Subscription> findByBookIdAndSubscriberName(Subscription subscription){
		return mongoTemplate.find(getQuery(subscription), Subscription.class);
	}
	
	public boolean checkSubscriptionAlreadyExistInDBWithoutReturn(Subscription subscription) {
		if(mongoTemplate.find(getQuery(subscription), Subscription.class).size()==0){return true;}
		return false;
	}
	
	private Query getQuery(Subscription subscription) {
		Query query = new Query();
		return query.addCriteria(
			    new Criteria().andOperator(
				        Criteria.where("bookId").is(subscription.getBookId()),
				        Criteria.where("subscriberName").is(subscription.getSubscriberName()),
				        Criteria.where("dateReturned").exists(false)
				    )
				);
	}

}
