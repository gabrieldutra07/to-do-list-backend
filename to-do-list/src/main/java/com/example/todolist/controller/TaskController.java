package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entity.Tasks;
import com.example.todolist.service.TaskService;
import com.example.todolist.service.UserService;

@RestController
@RequestMapping("/api/todolist/task")
public class TaskController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Tasks>> getTasks(@RequestParam Long listId) throws Exception {
	
		List<Tasks> t = taskService.findTasks(listId);
		
		return ResponseEntity.ok().body(t);
		
	}

}
