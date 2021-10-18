package com.java.springdemo.exercises.bookexercise.service;

import com.java.springdemo.exercises.bookexercise.model.Book;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static Map<Integer, Book> bookMap = new HashMap<>();
    private SecureRandom random = new SecureRandom();

    static {
        Book endersgame = new Book();
        endersgame.setId(1);
        endersgame.setName("Ender's Game");
        endersgame.setAuthor("Orson Scott Card");
        bookMap.put(endersgame.getId(), endersgame);

        Book lotr = new Book();
        lotr.setId(2);
        lotr.setName("The Lord of the Rings");
        lotr.setAuthor("J. R. R. Tolkien");
        bookMap.put(lotr.getId(), lotr);
    }

    // get all books
    public List<Book> retrieveAllBooks() {
        return bookMap.values().stream().collect(Collectors.toList());
    }

    // get book by id
    public Book retrieveBookById(int id) {
        return bookMap.get(id);
    }

    // post book
    public void addNewBook(Book newBook) {
        Book book = new Book();
        book.setId(Math.abs(random.nextInt()));
        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());
        bookMap.put(book.getId(), book);
    }

    // put book
    public void updateBookAuthor(int id, Book updatedBook) {
        Book book = null;
        if(bookMap.containsKey(id)) {
            book = bookMap.get(id);
            book.setAuthor(updatedBook.getAuthor());
        }
    }

    // delete book
    public void deleteBookById(int id) {
        if(bookMap.containsKey(id)){
            bookMap.remove(id);
        }
    }
}
