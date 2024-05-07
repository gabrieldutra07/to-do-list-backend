package com.example.todolist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.TaskDTO;
import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.Tasks;
import com.example.todolist.entity.User;
import com.example.todolist.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User getUser(UserDTO u) throws Exception {
		
		Optional<User> user = repository.findByEmailAndPasswordAndConfmail(u.getEmail(), u.getPassword(), true);
		
		return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado ou não confirmou e-mail!"));
		
	}
	
	public User findByEmail(String email) throws Exception {
		
		Optional<User> user = repository.findByEmail(email);
		
		return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado ou não confirmou e-mail!"));
		
	}
	
	public void confirmEmail(User u) {
			
		u.setConfmail(true);
		
	    repository.save(u);
				
	}
	
	public User saveUser(UserDTO u) throws Exception {
		
		try {
			
			User user = new User();
			user.setEmail(u.getEmail());
			user.setPassword(u.getPassword());
			user.setNameUser(u.getNameUser());
			return repository.save(user);
			
		} catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Email already exists: " + u.getEmail(), e);
        }
	}
	
	public User findUserById(Long id) throws Exception {
		  
	    Optional<User> optionalUser = repository.findById(id);

	    return optionalUser.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
	}

}
