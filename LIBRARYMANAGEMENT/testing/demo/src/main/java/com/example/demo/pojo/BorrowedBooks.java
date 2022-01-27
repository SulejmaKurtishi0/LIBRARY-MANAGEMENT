package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="borrowedbooks")

public class BorrowedBooks {
    //Relationships
    @ManyToOne
    @JoinColumn(name="bookID")
    @JsonManagedReference
    private Book book;

    @ManyToOne
    @JoinColumn(name = "mID")
    @JsonManagedReference
    private Member member;

    @Id
    @Column(name = "dateofborrow")
    private Date dateOfBorrow;
    @Column(name="returndate")
    private Date returnDate;

    //Default Constructor
    public BorrowedBooks() {
    }

    //Constructor with parameters
    public BorrowedBooks(Book book, Member member, Date dateOfBorrow, Date returnDate) {
        this.book = book;
        this.member = member;
        this.dateOfBorrow = dateOfBorrow;
        this.returnDate = returnDate;
    }

    //Getters and Setters
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

