package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="publishingHouse")
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="phID")
    private Integer id;

    @Column(name="Name")
    private String Name;

    @Column(name="Address")
    private String address;

    @Column(name="nrBooks")
    private Integer nrBooks;

    @OneToMany(mappedBy = "publishingHouse")
    @JsonManagedReference
    private List<Book> books;


    public PublishingHouse(Integer id, String name, String address, Integer nrBooks) {
        this.id = id;
        Name = name;
        this.address = address;
        this.nrBooks = nrBooks;
    }

    public PublishingHouse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNrBooks() {
        return nrBooks;
    }

    public void setNrBooks(Integer nrBooks) {
        this.nrBooks = nrBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
