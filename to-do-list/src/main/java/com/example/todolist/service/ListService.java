package com.example.todolist.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.entity.Lists;
import com.example.todolist.entity.User;
import com.example.todolist.repository.ListRepository;

import jakarta.transaction.Transactional;

@Service
public class ListService {

	@Autowired
	private ListRepository listRepository;
	
	public List<Lists> getListFromUser(Long id) {
			
	    List<Lists> l = listRepository.findByUserId(id);
			
		return l;
			
	}
	
	@Transactional
	public Lists saveList(ListDTO listDto) throws Exception {
		
		Lists list = new Lists();
		
		list.setTitle(listDto.getTitle());
		list.setUserId(listDto.getUserId());
		list.setDateCreated(new Date());
		
		return listRepository.save(list);
		
	}
	
	public void deleteList(Lists list) throws Exception {
		
		try {
			listRepository.delete(list);
			
		} catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Você não pode excluir uma lista com tarefas associadas.", null);
        }
		
	}
	
	public Lists findListById(Long id) throws Exception {
		
		Optional<Lists> l = listRepository.findById(id);
		
		return l.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "list not found"));
		
	}
	
	

}
