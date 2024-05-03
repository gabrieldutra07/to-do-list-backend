package com.example.todolist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.dto.ListDTO;
import com.example.todolist.entity.Lists;

public interface ListRepository extends JpaRepository<Lists, Long> {
	
	Optional<List<ListDTO>> findByUserId(Long id);

}
