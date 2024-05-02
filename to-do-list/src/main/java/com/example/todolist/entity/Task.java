package com.example.todolist.entity;

public class Task {
	
	public int id;
	
	public String listId;
	
	public String description;
	
	public boolean isComplete;
	
	public String dueDate;
	
	public String completedAt;
	
	public Task() {
	}

	public Task(int id, String listId, String description, boolean isComplete, String dueDate, String completedAt) {
		super();
		this.id = id;
		this.listId = listId;
		this.description = description;
		this.isComplete = isComplete;
		this.dueDate = dueDate;
		this.completedAt = completedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(String completedAt) {
		this.completedAt = completedAt;
	}
	
	

}
