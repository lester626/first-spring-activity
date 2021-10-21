package com.java.springdemo.exercises.bookexercise.controller;

import com.java.springdemo.exercises.bookexercise.exception.global.FirstBookGlobalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.local.FirstBookLocalNotFoundException;
import com.java.springdemo.exercises.bookexercise.exception.global.SecondBookGlobalBadRequestException;
import com.java.springdemo.exercises.bookexercise.exception.local.SecondBookLocalBadRequestException;
import com.java.springdemo.exercises.bookexercise.model.Book;
import com.java.springdemo.exercises.bookexercise.model.ErrorModel;
import com.java.springdemo.exercises.bookexercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    // GET All Books
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.retrieveAllBooks();
    }

    // GET Book by ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id) {
        if(bookService.retrieveBookById(id) == null) {
            throw new FirstBookGlobalNotFoundException();
        }
        return bookService.retrieveBookById(id);
    }

    // POST Book
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Book> postBook(@RequestBody Book newBook) {
        if(newBook.getName() == null || newBook.getAuthor() == null) {
            throw new SecondBookGlobalBadRequestException();
        }
        bookService.addNewBook(newBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT Book
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBookById(@PathVariable int id, @RequestBody Book updatedBook) {
        if(bookService.retrieveBookById(id) == null) {
            throw new FirstBookLocalNotFoundException("Book Not Found From Local Exception");
        }
        bookService.updateBookAuthor(id, updatedBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE Book
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        if(bookService.retrieveBookById(id) == null) {
            throw new SecondBookLocalBadRequestException("Book Bad Request From Local Exception");
        } else {
            bookService.deleteBookById(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //GET Book by ID via Params
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Book getBookByIdParams(@RequestParam int id) {
        return bookService.retrieveBookById(id);
    }

    // POST Book via Params
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Book> postBookParams(@RequestParam String name, @RequestParam String author) {
        Book book = new Book();
        if(name.equals("") || author.equals("")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            book.setName(name);
            book.setAuthor(author);
            bookService.addNewBook(book);
        }
        return new ResponseEntity<>(HttpStatus.OK);
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