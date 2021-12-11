package com.java.springdemo.exercises.bookexercise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    private int id;

    @Column(name = "TITLE")
    @NotNull
    @NotEmpty
    private String title;

    @Column(name = "AUTHOR")
    @NotNull
    @NotEmpty
    private String author;

    @Column(name = "YRPUBLISHED")
    private Date yearpublished;
}
