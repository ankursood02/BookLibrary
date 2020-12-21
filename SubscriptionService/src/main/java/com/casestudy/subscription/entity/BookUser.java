package com.casestudy.subscription.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookUser {

	@Id
	String userId;
	String subscriber_name,password,email;	
	
	
	public BookUser() {
		super();
	}

	public BookUser(String userId, String subscriber_name, String password, String email) {
		super();
		this.userId = userId;
		this.subscriber_name = subscriber_name;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the subscriber_name
	 */
	public String getSubscriber_name() {
		return subscriber_name;
	}

	/**
	 * @param subscriber_name the subscriber_name to set
	 */
	public void setSubscriber_name(String subscriber_name) {
		this.subscriber_name = subscriber_name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BookUser [userId=" + userId + ", subscriber_name=" + subscriber_name + ", password=" + password
				+ ", email=" + email + "]";
	}
	
	
	
}
