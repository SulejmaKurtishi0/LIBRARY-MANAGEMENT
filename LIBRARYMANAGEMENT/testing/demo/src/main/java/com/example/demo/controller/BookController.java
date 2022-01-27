package com.example.demo.controller;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.input.BookInput;
import com.example.demo.service.BookService;
import com.example.demo.service.DefaultBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    @Autowired
    private DefaultBookService bookService;

    @GetMapping("/book")
    public List<Book> getBook() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.findBookById(id);
    }

    @PostMapping("/book")
    public Book insertNewBook(@RequestBody BookInput bookInput) {
        return bookService.save(bookInput);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable Integer id,
                           @RequestBody BookInput bookInput) {
        return bookService.update(id,bookInput);
    }

    @DeleteMapping("/book/{id}")
    public Boolean deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return true;
    }
}
