package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.entity.Lists;
import com.example.todolist.entity.User;
import com.example.todolist.repository.ListRepository;

import jakarta.transaction.Transactional;

@Service
public class ListService {

	@Autowired
	private ListRepository listRepository;
	
	public List<Lists> getListFromUser(User u) {
			
	    List<Lists> l = listRepository.findByUserId(u.getId());
			
		return l;
			
	}
	
	@Transactional
	public Lists saveList(ListDTO listDto) throws Exception {
		
		Lists list = new Lists();
		
		list.setTitle(listDto.getTitle());
		list.setUserId(listDto.getUserId());
		
		return listRepository.save(list);
		
	}
	
	

}
