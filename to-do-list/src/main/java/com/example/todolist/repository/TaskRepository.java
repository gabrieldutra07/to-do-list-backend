package com.example.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{

	List<Tasks> findByListId(Long listId);
	
}
