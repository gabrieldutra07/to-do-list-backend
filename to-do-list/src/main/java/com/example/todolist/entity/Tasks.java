package com.example.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tasks {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long listId;
	
	private String description;
	
	private Boolean isComplete;
	
	public Tasks() {
	}

	public Tasks(Long id, Long listId, String description, Boolean isComplete) {
		super();
		this.id = id;
		this.listId = listId;
		this.description = description;
		this.isComplete = isComplete;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isComplete() {
		return isComplete;
	}

	public void setComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

}
