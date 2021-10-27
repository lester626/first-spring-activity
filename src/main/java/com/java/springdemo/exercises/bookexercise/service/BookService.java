package com.java.springdemo.exercises.bookexercise.service;

import com.java.springdemo.exercises.bookexercise.model.Book;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface BookService {

    public List<Book> retrieveAllBooks();
    public Book retrieveBookById(int id);
    public String addNewBook(List<Book> bookList);
    public String updateBook(Book updatedBook);
    public String deleteBookById(int id);
}
