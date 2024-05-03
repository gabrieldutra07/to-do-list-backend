package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.Lists;
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
	public ResponseEntity<List<Lists>> getList(@RequestBody UserDTO u) throws Exception {
		
		User user = new User();
		
		user = userService.findUserByEmail(u);

		List<Lists> l = service.getListFromUser(user);
		
		return ResponseEntity.ok().body(l);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity createList(@RequestBody ListDTO l) throws Exception {
		
		User user = new User();
		
		user = userService.findUserById(l.getUserId());
		
		Lists lists = new Lists();
		
		lists = service.saveList(l);
		
		return new ResponseEntity(lists, HttpStatus.CREATED);
		
	}
	
	
}
