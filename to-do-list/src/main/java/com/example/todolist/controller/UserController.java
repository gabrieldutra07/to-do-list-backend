package com.example.todolist.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/todolist/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
    
	@PostMapping("/login")
	public ResponseEntity isAuthenticated(@RequestBody UserDTO u) throws Exception {
		
		User user = new User();
		
		user = service.getUser(u);
		
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/create")
	public ResponseEntity save(@RequestBody UserDTO u) throws Exception {

		User user = new User();
		
		if (!Pattern.matches(EMAIL_REGEX, u.getEmail())) 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid e-mail format.");
        
		
		user = service.saveUser(u);
		
		return new ResponseEntity(user, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findUser")
	public ResponseEntity<User> findUser(@RequestBody UserDTO u) throws Exception {

		User user = service.findUserByEmail(u);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	
}
