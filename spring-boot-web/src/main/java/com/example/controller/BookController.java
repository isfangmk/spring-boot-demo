package com.example.controller;

import com.example.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BookController {

    @GetMapping("/book")
    public Book book() {
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPrice(30f);
        book.setPublicationDate(LocalDateTime.now());
        return book;
    }
}
