package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.dto.ListTaskCountDTO;
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
	public ResponseEntity<List<Lists>> getList(@RequestParam Long userId) throws Exception {

		List<Lists> l = service.getListFromUser(userId);
		
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
	
	@GetMapping("/getAllListsAndTasks")
	public ResponseEntity getAllListsAndTasks(@RequestParam Long userId) throws Exception {
		
		User user = new User();
		
		user = userService.findUserById(userId);
		
		ListTaskCountDTO listTask = new ListTaskCountDTO();
		
		listTask = service.getListsAndTasks(userId);
		
		return new ResponseEntity(listTask, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity delete(@RequestParam Long listId) throws Exception {
		
		Lists list = new Lists();
		
		list = service.findListById(listId);
		
		service.deleteList(list);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/edit")
	public ResponseEntity editTask(@RequestBody ListDTO listDto, @RequestParam("listId") Long listId) throws Exception {
		
		Lists list = new Lists();
		
		list = service.findListById(listId);
		
		list = service.editList(list, listDto);
		
		return new ResponseEntity(list, HttpStatus.OK);
		
	}
	
	
}
