package com.java.springdemo.exercises.bookexercise.service;

import com.java.springdemo.exercises.bookexercise.exception.global.FirstBookGlobalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.global.SecondBookGlobalBadRequestException;
import com.java.springdemo.exercises.bookexercise.model.Book;
import com.java.springdemo.exercises.bookexercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    SecureRandom random = new SecureRandom();

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> retrieveAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book retrieveBookById(int id) {
        Book book = null;
        if(!bookRepository.existsById(id)) {
            throw new FirstBookGlobalNotFoundException();
        }
        book = bookRepository.findById(id).get();
        return book;
    }

    @Override
    @Transactional
    public String addNewBook(List<Book> bookList) {
        int numOfBooks = (int) bookRepository.count() + 1;
        String message = "Number of books: " + numOfBooks + ", Books Added";
//        for(Book book: bookList) {
//            if(bookRepository.existsById(book.getId())) {
//                throw new SecondBookGlobalBadRequestException();
//            }
//        }
        bookRepository.saveAll(bookList);
        return message;
    }

    @Override
    @Transactional
    public String updateBook(Book updatedBook) {
        String message = "Book is updated";
//        if(!bookRepository.existsById(updatedBook.getId())) {
//            throw new FirstBookGlobalNotFoundException();
//        }
        bookRepository.save(updatedBook);
        return message;
    }

    @Override
    @Transactional
    public String deleteBookById(int id) {
        String message = "Book deleted";
        if(!bookRepository.existsById(id)) {
            throw new FirstBookGlobalNotFoundException();
        }
        bookRepository.delete(bookRepository.findById(id).get());
        return message;
    }
}
