package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("User is valid");
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleArgumentNotValidException(final MethodArgumentNotValidException argumentNotValidException) {
//        Map<String, String> errors = new HashMap<>();
//        argumentNotValidException.getBindingResult().getAllErrors().forEach(objectError -> {
//            String field = ((FieldError) objectError).getField();
//            String errorMessage = objectError.getDefaultMessage();
//            errors.put(field, errorMessage);
//        });
//        return errors;
//    }
}
