package com.example.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.TaskDTO;
import com.example.todolist.entity.Tasks;
import com.example.todolist.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Tasks> findTasks(Long id) {
		
	    List<Tasks> t = repository.findByListId(id);
			
		return t;
			
	}
	
	@Transactional
	public Tasks saveTask(Tasks t) {
		
	    return repository.save(t);
			
	}
	
	public Tasks editTask(Tasks t, TaskDTO taskDto) {
		
		t.setComplete(taskDto.isComplete());
		t.setDescription(taskDto.getDescription());
		t.setListId(taskDto.getListId());
		
	    return repository.save(t);
			
	}
	
	public Tasks findTaskById(Long id) {
			
		Optional<Tasks> l = repository.findById(id);
		
		return l.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found"));
				
	}
	
	public void deleteTask(Tasks t) {
			
		repository.delete(t);
			
	}

}
