package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.service.ListService;

@RestController
@RequestMapping("/api/todolist")
public class ListController {
	
	@Autowired
	private ListService service;
	
	
	@GetMapping("/login")
	public ResponseEntity<User> isAuthenticated(@RequestBody UserDTO u) throws Exception{
		
		User user = new User();
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());

		user = service.getUser(u);
		
		return ResponseEntity.ok().body(user);
		
	}
	
	
}
