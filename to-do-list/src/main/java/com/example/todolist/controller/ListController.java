package com.example.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.UserDTO;

@RestController
@RequestMapping("/api/todolist")
public class ListController {
	
	
	@GetMapping("/login")
	public ResponseEntity<?> isAuthenticated(@RequestBody UserDTO u) {
		
		
		
		return ResponseEntity.ok().build();
		
	}
	
	
}
