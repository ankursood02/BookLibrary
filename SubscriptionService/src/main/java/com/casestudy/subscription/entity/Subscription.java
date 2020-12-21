package com.casestudy.subscription.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
public class Subscription {
	
	@Id
	String _id;
	
	
	
	
	public Subscription() {
		super();		
	}
	public Subscription(String _id, String subscriberName, String bookId, LocalDate dateSubscribed,
			LocalDate dateReturned, String notify) {
		super();
		this._id = _id;
		this.subscriberName = subscriberName;
		this.bookId = bookId;
		this.dateSubscribed = dateSubscribed;
		this.dateReturned = dateReturned;
		this.notify = notify;
	}
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the subscriberName
	 */
	public String getSubscriberName() {
		return subscriberName;
	}
	/**
	 * @param subscriberName the subscriberName to set
	 */
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the dateSubscribed
	 */
	public LocalDate getDateSubscribed() {
		return dateSubscribed;
	}
	/**
	 * @param dateSubscribed the dateSubscribed to set
	 */
	public void setDateSubscribed(LocalDate dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	/**
	 * @return the dateReturned
	 */
	public LocalDate getDateReturned() {
		return dateReturned;
	}
	/**
	 * @param dateReturned the dateReturned to set
	 */
	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}
	/**
	 * @return the notify
	 */
	public String getNotify() {
		return notify;
	}
	/**
	 * @param notify the notify to set
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}
	String subscriberName;
	String bookId;
	LocalDate dateSubscribed;
	LocalDate dateReturned;
    String notify;
    
    

	@Override
	public String toString() {
		return "Subscription [_id=" + _id + ", subscriberName=" + subscriberName + ", bookId=" + bookId
				+ ", dateSubscribed=" + dateSubscribed + ", dateReturned=" + dateReturned + ", notify=" + notify + "]";
	}
}
