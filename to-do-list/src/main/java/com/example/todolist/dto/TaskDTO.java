package com.example.todolist.dto;

public class TaskDTO {
	
	private Long listId;
	private String description;
	private Boolean isComplete;
	
	public TaskDTO() {
		
	}
	
	public TaskDTO(Long listId, String description, Boolean isComplete) {
		super();
		this.listId = listId;
		this.description = description;
		this.isComplete = isComplete;
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
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	

}
