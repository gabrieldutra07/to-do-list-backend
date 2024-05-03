package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.TaskDTO;
import com.example.todolist.entity.Lists;
import com.example.todolist.entity.Tasks;
import com.example.todolist.service.ListService;
import com.example.todolist.service.TaskService;

@RestController
@RequestMapping("/api/todolist/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ListService listService;
	
	@GetMapping("/get")
	public ResponseEntity<List<Tasks>> getTasks(@RequestParam Long listId) throws Exception {
	
		List<Tasks> t = taskService.findTasks(listId);
		
		return ResponseEntity.ok().body(t);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity createTasks(@RequestBody TaskDTO taskDto) throws Exception {
		
		Tasks task = new Tasks();
		Lists list = new Lists();
		
		list = listService.findListById(taskDto.getListId());
		
		task.setComplete(taskDto.isComplete());
		task.setDescription(taskDto.getDescription());
		task.setListId(taskDto.getListId());
		
		task = taskService.saveTask(task);
		
		return new ResponseEntity(task, HttpStatus.CREATED);
		
	}

}
