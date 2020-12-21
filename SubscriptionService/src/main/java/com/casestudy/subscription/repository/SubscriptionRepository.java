package com.casestudy.subscription.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.subscription.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,String>{
}




