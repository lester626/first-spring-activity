package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.exception.SecondException;
import com.java.springdemo.notes.exception.ThirdException;
import com.java.springdemo.notes.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class ExceptionController {

    @GetMapping("/exception/resource")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throwSecondException() {
        throw new SecondException("throwException: Second Exception");
    }

    @GetMapping("/exception/resource/subresource")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throwThirdException() {
        throw new ThirdException("throwException: Third Exception");
    }

    @GetMapping("/exception/resource/subresource/anotherresource")
    public void throwAnotherException() {
        throw new SecondException("throwException: Second Exception");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SecondException.class)
    public Error handleSecondException(final SecondException secondException) {
        return new Error(secondException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ThirdException.class)
    public Error handleThirdException(final ThirdException thirdException) {
        return new Error(thirdException.getMessage());
    }
}
