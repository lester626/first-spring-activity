package com.java.springdemo.exercises.bookexercise.controller;

import com.java.springdemo.exercises.bookexercise.exception.global.FirstBookGlobalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.global.SecondBookGlobalBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookGlobalExceptionController {

    @ExceptionHandler(FirstBookGlobalNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(FirstBookGlobalNotFoundException firstBookGlobalNotFoundException) {
        return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SecondBookGlobalBadRequestException.class)
    public ResponseEntity<Object> handleBookBadRequestException(SecondBookGlobalBadRequestException secondBookGlobalBadRequestException) {
        return new ResponseEntity<>("Book Already Existed", HttpStatus.BAD_REQUEST);
    }
}
