package com.example.demo.pojo.input;

public class MemberInput {
    private String name;
    private String surname;
    private Integer nrbooks;


    public MemberInput(String name, String surname, Integer nrbooks) {
        this.name = name;
        this.surname = surname;
        this.nrbooks = nrbooks;
    }

    public MemberInput() {
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
}
