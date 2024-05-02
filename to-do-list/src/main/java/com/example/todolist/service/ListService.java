package com.example.todolist.service;

import java.util.List;
import java.util.Optional;

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
	
	public void saveUser(UserDTO u) throws Exception {
			
			User user = new User();
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			
			repository.save(user);
			
		}
	
	public User findUser(UserDTO u) throws Exception {
	    // Supondo que o repositório é injetado e disponível como 'repository'
	    Optional<User> optionalUser = repository.findByEmail(u.getEmail());

	    return optionalUser.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
	}

}
