package com.example.demo.repository;

import com.example.demo.pojo.BorrowedBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;

import java.util.List;

@Repository
public interface BorrowedBooksRepository  extends CrudRepository<BorrowedBooks,Date>
{
    List<BorrowedBooks> findAll();
    BorrowedBooks findBorrowedBooksByDateOfBorrow(Date dateOfBorrow);
}
