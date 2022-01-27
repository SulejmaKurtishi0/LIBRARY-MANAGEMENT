package com.example.demo.pojo.input;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.ReadingTable;


public class TablesBookedInput {

    private Book book;
    private ReadingTable readingtable;
    private Integer tbID;


    public TablesBookedInput(Book book, ReadingTable readingtable, Integer tbID) {
        this.book = book;
        this.readingtable = readingtable;
        this.tbID = tbID;
    }

    public TablesBookedInput() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ReadingTable getReadingtable() {
        return readingtable;
    }

    public void setReadingtable(ReadingTable readingtable) {
        this.readingtable = readingtable;
    }

    public Integer getTbID() {
        return tbID;
    }

    public void setTbID(Integer tbID) {
        this.tbID = tbID;
    }
}
