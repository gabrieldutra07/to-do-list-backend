package com.example.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.entity.User;
import com.example.todolist.repository.ListRepository;

@Service
public class ListService {

	@Autowired
	private ListRepository listRepository;
	
	public List<ListDTO> getListFromUser(User u) {
			
			Optional<List<ListDTO>> l = listRepository.findByUserId(u.getId());
			
			return l.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "list not found"));
			
		}

}
