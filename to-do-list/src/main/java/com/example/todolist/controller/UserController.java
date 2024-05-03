package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;

@RestController
@RequestMapping("/api/todolist")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/login")
	public ResponseEntity<User> isAuthenticated(@RequestBody UserDTO u) throws Exception {
		
		User user = new User();
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());

		user = service.getUser(u);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO u) throws Exception {

		service.saveUser(u);
		
		return ResponseEntity.ok().body(u);
		
	}
	
	@GetMapping("/findUser")
	public ResponseEntity<User> findUser(@RequestBody UserDTO u) throws Exception {

		User user = service.findUserByEmail(u);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	
}
