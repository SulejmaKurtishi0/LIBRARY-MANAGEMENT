package com.example.demo.pojo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="readingtable")
public class ReadingTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="rtID")
    private Integer id;

    @Column(name="availability")
    private String availability;
   /* @ManyToMany
    @JoinTable
            (
                    name="bookedtables",
                    joinColumns = @JoinColumn(name="rtID"),
                    inverseJoinColumns = @JoinColumn(name="bID")

            )
    private Set<Book> tablesbooked= new HashSet<>();*/

    @OneToMany(mappedBy="book")
    @JsonBackReference
    private List<TablesBooked> TablesBookedList;

    @OneToOne(mappedBy ="readingTable")
    private Member member;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public ReadingTable(Integer id, String availability) {
        this.id = id;
        this.availability = availability;
    }

    public ReadingTable() {
    }

    /*public Set<Book> getTablesbooked() {
        return tablesbooked;
    }

    public void setTablesbooked(Set<Book> tablesbooked) {
        this.tablesbooked = tablesbooked;
    }*/

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


}
