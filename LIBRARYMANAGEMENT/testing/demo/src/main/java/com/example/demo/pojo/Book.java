package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bID")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "availability")
    private String availability;

    /* @JsonIgnore
     @ManyToMany(mappedBy = "borrowedbooks")
     private Set<Member> members = new HashSet<>();
     @JsonIgnore
     @ManyToMany(mappedBy = "tablesbooked")
     private Set<ReadingTable> readingTables = new HashSet<>();*/
    /*


*/
    @OneToMany(mappedBy="book")
    @JsonBackReference
    private List<BorrowedBooks> BorrowedBooksList;

    @OneToMany(mappedBy="book")
    @JsonBackReference
    private List<TablesBooked> TablesBookedList;

    @ManyToOne
    @JoinColumn(name="phID")
    @JsonBackReference
    private PublishingHouse publishingHouse;
    //Constructor
    public Book(Integer id, String title, String author, String availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    //Default Constructor
    public Book() {
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

   /* public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<ReadingTable> getReadingTables() {
        return readingTables;
    }

    public void setReadingTables(Set<ReadingTable> readingTables) {
        this.readingTables = readingTables;
    }

    */

  /*  public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public List<BorrowedBooks> getBorrowedBooksList() {
        return BorrowedBooksList;
    }

    public void setBorrowedBooksList(List<BorrowedBooks> BorrowedBooksList) {
        this.BorrowedBooksList = BorrowedBooksList;
    }

    public List<TablesBooked> getTablesbookedList() {
        return TablesBookedList;
    }

    public void setTablesBookedList(List<TablesBooked> TablesBookedList) {
        this.TablesBookedList = TablesBookedList;
    }*/
}
