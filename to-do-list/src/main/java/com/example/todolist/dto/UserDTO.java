package com.example.todolist.dto;

import java.util.List;

public class UserDTO {
	
	public String email;
	public String password;
	public List<ListDTO> lists;
	
	
	public UserDTO() {
	}
	
	public List<ListDTO> getLists() {
		return lists;
	}

	public void setLists(List<ListDTO> lists) {
		this.lists = lists;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
