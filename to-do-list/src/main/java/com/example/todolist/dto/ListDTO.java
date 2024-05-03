package com.example.todolist.dto;

public class ListDTO {
	
	private String title;
	private Long userId;
	
	public ListDTO() {
		
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
