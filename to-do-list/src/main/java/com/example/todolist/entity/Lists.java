package com.example.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lists {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String title;
	
	public Long userId;
	
	public Lists() {
	
	}
	
	public Lists(Long id, String title, Long userId) {
		this.id = id;
		this.title = title;
		this.userId = userId;
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

}
