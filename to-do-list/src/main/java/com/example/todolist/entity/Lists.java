package com.example.todolist.entity;

public class Lists {
	
	public Long id;
	
	public String title;
	
	public Long userId;
	
	public String dateCreated;
	
	public Lists() {
	
	}
	
	public Lists(Long id, String title, Long userId, String dateCreated) {
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.dateCreated = dateCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	} 
	
	

}
