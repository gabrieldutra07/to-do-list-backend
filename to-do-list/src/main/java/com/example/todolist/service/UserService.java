package com.example.todolist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User getUser(UserDTO u) throws Exception {
		
		Optional<User> user = repository.findByEmail(u.getEmail());
		
		return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
		
	}
	
	public void saveUser(UserDTO u) throws Exception {
			
			User user = new User();
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			
			repository.save(user);
			
		}
	
	public User findUserByEmail(UserDTO u) throws Exception {
	  
	    Optional<User> optionalUser = repository.findByEmail(u.getEmail());

	    return optionalUser.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
	}
	
	public User findUserById(Long id) throws Exception {
		  
	    Optional<User> optionalUser = repository.findById(id);

	    return optionalUser.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
	}

}
