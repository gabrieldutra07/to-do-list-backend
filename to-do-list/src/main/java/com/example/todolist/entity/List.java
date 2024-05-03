package com.example.todolist.entity;

public class List {
	
	public Long id;
	
	public String title;
	
	public int userId;
	
	public String dateCreated;
	
	public List() {
	
	}
	
	public List(Long id, String title, int userId, String dateCreated) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	} 
	
	

}
