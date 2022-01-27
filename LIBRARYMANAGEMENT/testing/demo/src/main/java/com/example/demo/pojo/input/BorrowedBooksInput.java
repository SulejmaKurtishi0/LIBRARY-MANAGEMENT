package com.example.demo.pojo.input;
import com.example.demo.pojo.Book;
import com.example.demo.pojo.Member;


import java.sql.Date;

public class BorrowedBooksInput {

    private Book book;
    private Member member;
    private Date dateOfBorrow;
    private Date returnDate;

    public BorrowedBooksInput() {
    }

    public BorrowedBooksInput(Book book, Member member, Date dateOfBorrow, Date returnDate) {
        this.book = book;
        this.member = member;
        this.dateOfBorrow = dateOfBorrow;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getDateOfBorrow() {
        return dateOfBorrow;
    }

    public void setDateOfBorrow(Date dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

