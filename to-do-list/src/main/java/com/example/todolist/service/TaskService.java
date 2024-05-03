package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.entity.Tasks;
import com.example.todolist.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Tasks> findTasks(Long id) {
		
	    List<Tasks> t = repository.findByListId(id);
			
		return t;
			
	}
	
	public Tasks saveTask(Tasks t) {
		
	    return repository.save(t);
			
	}

}
