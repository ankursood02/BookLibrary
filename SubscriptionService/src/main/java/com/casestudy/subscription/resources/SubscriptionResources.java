package com.casestudy.subscription.resources;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SubscriptionResources {
	
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		//in case we want to give request timeout
		/*
		 * HttpComponentsClientHttpRequestFactory httpRequestFactory=new
		 * HttpComponentsClientHttpRequestFactory();
		 * httpRequestFactory.setConnectTimeout(3000);
		 * httpRequestFactory.setConnectionRequestTimeout(3000);
		 * httpRequestFactory.setReadTimeout(3000); return new
		 * RestTemplate(httpRequestFactory);
		 */
		return new RestTemplate();
	}
	
	
	
	


}
