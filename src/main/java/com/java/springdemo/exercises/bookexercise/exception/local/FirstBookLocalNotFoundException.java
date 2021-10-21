package com.java.springdemo.exercises.bookexercise.exception.local;

public class FirstBookLocalNotFoundException extends RuntimeException{
    public FirstBookLocalNotFoundException(String message) {
        super(message);
    }
}
