package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;

@Service
public class ListService {
	
	@Autowired
	private UserRepository repository;
	
	public List<ListDTO> getListFromUser(User u) {
		return null;
		
	}
	
	public User getUser(UserDTO u) throws Exception {
		
		User user = null;
		
		user = repository.findByEmailAndPassword(u.getEmail(), u.getPassword());
		
		if(user == null)
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");

		return user;
		
	}
	
	public User saveUser(UserDTO u) throws Exception {
			
			User user = null;
			
			user = repository.findByEmailAndPassword(u.getEmail(), u.getPassword());
			
			if(user == null)
		        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
	
			return user;
			
		}

}
