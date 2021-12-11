package com.java.springdemo.exercises.bookexercise.service;

import com.java.springdemo.exercises.bookexercise.model.Book;
import java.util.List;

public interface BookService {

    public List<Book> retrieveAllBooks();
    public Book retrieveBookById(int id);
    public String addNewBook(List<Book> bookList);
    public String updateBook(Book updatedBook);
    public String deleteBookById(int id);
}
