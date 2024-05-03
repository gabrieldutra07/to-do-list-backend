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
import com.example.todolist.service.UserService;

@RestController
@RequestMapping("/api/todolist/list")
public class ListController {
	
	@Autowired
	private ListService service;
	
	@Autowired
	private UserService userService;

	@GetMapping("/get")
	public ResponseEntity<List<ListDTO>> getList(@RequestBody UserDTO u) throws Exception {
		
		User user = new User();
		
		user = userService.findUser(u);

		List<ListDTO> l = service.getListFromUser(user);
		
		return ResponseEntity.ok().body(l);
		
	}
	
	@GetMapping("/create")
	public ResponseEntity<List<ListDTO>> createList(@RequestBody UserDTO u, ListDTO list) throws Exception {
		
		User user = new User();
		
		user = userService.findUser(u);
		
		
		
		return null;
		
	}
	
}
