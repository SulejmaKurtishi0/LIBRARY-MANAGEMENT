package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="tablesbooked")

public class TablesBooked {
    @ManyToOne

    @JoinColumn(name="bID")
    @JsonManagedReference
    private Book book;

    @ManyToOne
    @JoinColumn(name = "rtID")
    @JsonManagedReference
    private ReadingTable readingtable;

    @Id
    @Column(name = "tbID")
    private Integer tbID;


    public TablesBooked (Book book, ReadingTable readingtable, Integer tbID) {
        this.book = book;
        this.readingtable = readingtable;
        this.tbID = tbID;
    }

    public TablesBooked() {
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


