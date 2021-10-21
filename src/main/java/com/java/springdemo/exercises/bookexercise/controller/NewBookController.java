package com.java.springdemo.exercises.bookexercise.controller;

import com.java.springdemo.exercises.bookexercise.exception.local.FirstBookLocalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.local.SecondBookLocalBadRequestException;
import com.java.springdemo.exercises.bookexercise.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBookController {

    @GetMapping("/books/notfound/exception")
    public void notFoundException() {
        throw new FirstBookLocalNotFoundException("Book Not Found");
    }

    @GetMapping("/books/badrequest/exception")
    public void badRequestException() {
        throw new FirstBookLocalNotFoundException("Book Bad Request");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FirstBookLocalNotFoundException.class)
    public ErrorModel handleNotFoundException(final FirstBookLocalNotFoundException firstBookLocalNotFoundException) {
        return new ErrorModel(firstBookLocalNotFoundException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SecondBookLocalBadRequestException.class)
    public ErrorModel handleBadRequestException(final SecondBookLocalBadRequestException secondBookLocalBadRequestException) {
        return new ErrorModel(secondBookLocalBadRequestException.getMessage());
    }
}
