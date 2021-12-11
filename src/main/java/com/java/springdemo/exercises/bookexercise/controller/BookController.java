package com.java.springdemo.exercises.bookexercise.controller;

import com.java.springdemo.exercises.bookexercise.exception.global.FirstBookGlobalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.local.FirstBookLocalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.global.SecondBookGlobalBadRequestException;
import com.java.springdemo.exercises.bookexercise.exception.local.SecondBookLocalBadRequestException;
import com.java.springdemo.exercises.bookexercise.model.Book;
import com.java.springdemo.exercises.bookexercise.model.ErrorModel;
import com.java.springdemo.exercises.bookexercise.service.BookService;
import com.java.springdemo.exercises.bookexercise.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;
    
    @Valid
    private List<Book> newBooks;

    // GET All Books
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookServiceImpl.retrieveAllBooks();
    }

    // GET Book by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id) {
//        if(bookServiceImpl.retrieveBookById(id) == null) {
//            throw new FirstBookGlobalNotFoundException();
//        }
        return bookServiceImpl.retrieveBookById(id);
    }

    // POST Book
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postBook(@RequestBody @Valid List<Book> newBooks) {
        return bookServiceImpl.addNewBook(newBooks);
    }

    // PUT Book
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateBookById(@Valid @RequestBody Book updatedBook) {
        return bookServiceImpl.updateBook(updatedBook);
    }

    // DELETE Book
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable int id) {
        return bookServiceImpl.deleteBookById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleArgumentNotValidException(final MethodArgumentNotValidException argumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        argumentNotValidException.getBindingResult().getAllErrors().forEach(objectError -> {
            String field = ((FieldError) objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(field, errorMessage);
        });
        return errors;
    }

    //GET Book by ID via Params
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Book getBookByIdParams(@RequestParam int id) {
//        return bookServiceImpl.retrieveBookById(id);
//    }

    // POST Book via Params
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public ResponseEntity<Book> postBookParams(@RequestParam String name, @RequestParam String author) {
//        Book book = new Book();
//        if(name.equals("") || author.equals("")) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            book.setTitle(name);
//            book.setAuthor(author);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}