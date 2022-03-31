package com.app.pojos;

public class IssueBook {
	
	Integer bookId;
	Integer user_id;
	public IssueBook(Integer bookId, Integer user_id) {
		super();
		this.bookId = bookId;
		this.user_id = user_id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "IssueBook [bookId=" + bookId + ", user_id=" + user_id + "]";
	}
	
}
