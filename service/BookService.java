package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.input.BookInput;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findBookById(Integer id);
    Book save(BookInput bookInput);
    Book update(Integer id, BookInput bookInput);
    void delete(Integer id);
}
