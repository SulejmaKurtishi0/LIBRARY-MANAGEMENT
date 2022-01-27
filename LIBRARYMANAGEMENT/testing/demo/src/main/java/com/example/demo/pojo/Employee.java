package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {

    //Relationships
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="eID")
    private Integer id;

    @Column(name="Name")
    private String name;

    @Column(name="Surname")
    private String surname;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Column(name="WorkingHours")
    private Integer workingHours;


    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Member> members;

    //Constructor with parameters
    public Employee(Integer id, String name, String surname, Integer workingHours) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingHours = workingHours;
    }
    //Default Constructor
    public Employee() {
    }
    //Geters and Setters
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

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public Employee(Integer id, String name, String surname, Integer workingHours, List<Member> members) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workingHours = workingHours;
        this.members = members;
    }
}
