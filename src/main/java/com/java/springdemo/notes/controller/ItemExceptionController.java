package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ItemExceptionController {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException itemNotFoundException) {
        return new ResponseEntity<>("Item Not Found", HttpStatus.NOT_FOUND);
    }
}
