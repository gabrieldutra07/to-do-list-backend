package com.example.todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmailAndPasswordAndConfmail(String email, String password, boolean confmail);
	
	Optional<User> findByEmail(String email);

	Optional<User> findById(Long id);

}
