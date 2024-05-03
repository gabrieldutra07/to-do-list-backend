package com.example.todolist.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
        // Verifica o status e personaliza a resposta com base no erro
       
            return ResponseEntity.status(ex.getStatusCode()).body(new ErrorMessage(ex.getStatusCode().value(), ex.getReason()));
        
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String customMessage = "An error occurred while processing your request.";
        // Você pode adicionar lógica específica para personalizar a mensagem com base na exceção
        if (ex.getMessage().contains("Duplicate entry")) {
            customMessage = "This email address is already registered. Please use a different email address.";
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    // Classe interna para estruturar a mensagem de erro
    public static class ErrorMessage {
        private int status;
        private String message;

        public ErrorMessage(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}