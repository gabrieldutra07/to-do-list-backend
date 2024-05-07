package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.Lists;

public interface ListRepository extends JpaRepository<Lists, Long> {
	
    List<Lists> findByUserId(Long userId);


}
