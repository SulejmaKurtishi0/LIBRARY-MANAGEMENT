package com.example.demo.controller;

import com.example.demo.pojo.BorrowedBooks;
import com.example.demo.pojo.input.BorrowedBooksInput;

import com.example.demo.service.DefaultBorrowedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class BorrowedBooksController {

    @Autowired
    private DefaultBorrowedBooksService borrowedBooksService;

    @GetMapping("/borrowedbooks")
    public List<BorrowedBooks> getBorrowedBooks() {
        return borrowedBooksService.findAll();
    }

    @GetMapping("/borrowedbooks/{dateOfBorrow}")
    public BorrowedBooks getBorrowedBookByDate(@PathVariable Date dateOfBorrow) {
        return borrowedBooksService.findBorrowedBooksByDateOfBorrow(dateOfBorrow);
    }

    @PostMapping("/borrowedbooks")
    public BorrowedBooks insertNewBorrowedBook(@RequestBody BorrowedBooksInput borrowedBooksInput) {
        return borrowedBooksService.save(borrowedBooksInput);
    }

    @PutMapping("/borrowedbooks/{dateOfBorrow}")
    public BorrowedBooks updateBorrowedBook(@PathVariable Date dateOfBorrow,
                                            @RequestBody BorrowedBooksInput borrowedBooksInput) {
        return borrowedBooksService.update(dateOfBorrow,borrowedBooksInput);
    }

    @DeleteMapping("/borrowedbooks/{dateOfBorrow}")
    public Boolean DeleteBorrowedBook(@PathVariable Date dateOfBorrow) {
        borrowedBooksService.delete(dateOfBorrow);
        return true;
    }
}


