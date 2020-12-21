package com.casestudy.subscription.model;


public class Book {
	
	
	String bookId;
	String bookName;
	String author;
	int copiesAvailable;
	int totalCopies;
	
	
	public Book() {
		super();
	}
	
	public Book(String bookId, String bookName, String author, int copiesAvailable, int totalCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.copiesAvailable = copiesAvailable;
		this.totalCopies = totalCopies;
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
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the copiesAvailable
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	/**
	 * @param copiesAvailable the copiesAvailable to set
	 */
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	/**
	 * @return the totalCopies
	 */
	public int getTotalCopies() {
		return totalCopies;
	}
	/**
	 * @param totalCopies the totalCopies to set
	 */
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", copiesAvailable="
				+ copiesAvailable + ", totalCopies=" + totalCopies + "]";
	}

	
	

}
