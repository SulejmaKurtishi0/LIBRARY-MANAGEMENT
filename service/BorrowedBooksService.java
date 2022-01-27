package com.example.demo.service;

import com.example.demo.pojo.BorrowedBooks;
import com.example.demo.pojo.input.BorrowedBooksInput;

import java.sql.Date;
import java.util.List;

public interface BorrowedBooksService {

    List<BorrowedBooks> findAll();
    BorrowedBooks findBorrowedBooksByDateOfBorrow(Date dateOfBorrow);
    BorrowedBooks save(  BorrowedBooksInput borrowedbooksInput);
    BorrowedBooks update(Date dateOfBorrow, BorrowedBooksInput borrowedbooksInput);
    void delete(Date dateOfBorrow);
}


