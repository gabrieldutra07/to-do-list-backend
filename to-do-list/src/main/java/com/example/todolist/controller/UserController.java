package com.example.todolist.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.todolist.dto.UserDTO;
import com.example.todolist.entity.User;
import com.example.todolist.service.EmailService;
import com.example.todolist.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/todolist/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private EmailService emailService;
	
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
    
	@PostMapping("/login")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity isAuthenticated(@RequestBody UserDTO u) throws Exception {
		
		User user = new User();
		
		user = service.getUser(u);
		
		return new ResponseEntity(user, HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody UserDTO u) throws Exception {

		User user = new User();
		
		if (!Pattern.matches(EMAIL_REGEX, u.getEmail())) 
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid e-mail format.");
		
		user = service.saveUser(u);

		String email = u.getEmail();
		String contentHtml = "Obrigado por se cadastrar. Clique <a href=\"http://localhost:8080/api/todolist/user/confirmEmail?email=" + email + "\">aqui</a> para confirmar seu e-mail!";
		
		emailService.sendEmail(u.getEmail(), "[INFO] Confirme seu e-mail", contentHtml);
		
		return new ResponseEntity(user, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/confirmEmail")
	public ResponseEntity confirmEmail(@RequestParam String email, HttpServletResponse response) throws Exception {

		User user = new User();
		
		user = service.findByEmail(email);
		
		service.confirmEmail(user);
		
		response.sendRedirect("http://localhost:5500/index.html");
		
		return new ResponseEntity(user, HttpStatus.OK);
		
	}
	
}
