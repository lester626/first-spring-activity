package com.java.springdemo.exercises.bookexercise.repository;

import com.java.springdemo.exercises.bookexercise.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
