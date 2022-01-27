package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.BorrowedBooks;
import com.example.demo.pojo.Member;

import com.example.demo.pojo.input.BorrowedBooksInput;
import com.example.demo.repository.BorrowedBooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service
public class DefaultBorrowedBooksService implements BorrowedBooksService{
    @Autowired
    private BorrowedBooksRepository borrowedBooksRepository;

    @Override
    public List<BorrowedBooks> findAll() {
        return borrowedBooksRepository.findAll();
    }

    @Override
    public BorrowedBooks findBorrowedBooksByDateOfBorrow(Date dateOfBorrow) {
        return borrowedBooksRepository.findBorrowedBooksByDateOfBorrow(dateOfBorrow);
    }

    @Override
    public BorrowedBooks save(BorrowedBooksInput borrowedBooksInput) {


        Book book = borrowedBooksInput.getBook();
        Member member = borrowedBooksInput.getMember();
        Date dateOfBorrow= borrowedBooksInput.getDateOfBorrow();
        Date returnDate= borrowedBooksInput.getReturnDate();

        BorrowedBooks borrowedbooks= new BorrowedBooks();
        borrowedbooks.setBook(book);
        borrowedbooks.setMember(member);
        borrowedbooks.setDateOfBorrow(dateOfBorrow);
        borrowedbooks.setReturnDate(returnDate);

        return borrowedBooksRepository.save(borrowedbooks);
    }

    @Override
    public BorrowedBooks update(Date dateOfBorrow, BorrowedBooksInput borrowedBooksInput) {
        BorrowedBooks borrowedbooks = borrowedBooksRepository.findBorrowedBooksByDateOfBorrow(dateOfBorrow);
        if (borrowedbooks == null) {
            return null;
        }

        Book updatedbook = borrowedBooksInput.getBook();
        Member updatedmember = borrowedBooksInput.getMember();
        Date updateddateOfBorrow= borrowedBooksInput.getDateOfBorrow();
        Date updatedreturnDate= borrowedBooksInput.getReturnDate();

        borrowedbooks.setBook(updatedbook);
        borrowedbooks.setMember(updatedmember);
        borrowedbooks.setDateOfBorrow(updateddateOfBorrow);
        borrowedbooks.setReturnDate(updatedreturnDate);

        return borrowedBooksRepository.save(borrowedbooks);
    }

    @Override
    public void delete(Date dateOfBorrow) {
        BorrowedBooks borrowedbooks = borrowedBooksRepository.findBorrowedBooksByDateOfBorrow(dateOfBorrow);
        if (borrowedbooks != null) {
            borrowedBooksRepository.delete(borrowedbooks);
        }

        borrowedBooksRepository.delete(borrowedbooks);
    }


}

