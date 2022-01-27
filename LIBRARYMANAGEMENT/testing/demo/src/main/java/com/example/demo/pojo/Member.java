package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "mID")
    private Integer id;


    @Column(name = "mName")
    private String name;

    @Column(name = "mSurname")
    private String surname;

    @Column(name = "nrBooks")
    private Integer nrbooks;

    /* @ManyToMany
     @JoinTable
             (
         name="booksborrowed",
         joinColumns = @JoinColumn(name="mID"),
         inverseJoinColumns = @JoinColumn(name="bID")

             )
     private Set<Book> borrowedbooks= new HashSet<>();*/
    /*@OneToMany(mappedBy="member")
    @JsonBackReference
    private List<BorrowedBooks> borrowedbooksList;*/

    @OneToMany(mappedBy="book")
    @JsonBackReference
    private List<BorrowedBooks> BorrowedBooksList;

    @ManyToOne
    @JoinColumn(name="eID")
    @JsonBackReference
    private Employee employee;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="rtID",referencedColumnName = "rtID")
    private ReadingTable readingTable;


    public Member(Integer id, String name, String surname, Integer nrbooks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nrbooks = nrbooks;
    }

    public Member() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNrbooks() {
        return nrbooks;
    }

    public void setNrbooks(Integer nrbooks) {
        this.nrbooks = nrbooks;
    }

    /*public Set<Book> getBorrowedbooks() {
        return borrowedbooks;
    }

    public void setBorrowedbooks(Set<Book> borrowedbooks) {
        this.borrowedbooks = borrowedbooks;
    }*/

   public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

   /* public List<BorrowedBooks> getBorrowedBooksList() {
        return borrowedbooksList;
    }

    public void setBorrowedBooksList(List<BorrowedBooks> borrowedbooksList) {
        this.borrowedbooksList = borrowedbooksList;
    }

    public ReadingTable getReadingTable() {
        return readingTable;
    }

    public void setReadingTable(ReadingTable readingTable) {
        this.readingTable = readingTable;
    }*/
}
