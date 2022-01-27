package com.example.demo.pojo.input;

public class PublishingHouseInput {

    private String Name;
    private String address;
    private Integer nrBooks;

    public PublishingHouseInput(String name, String address, Integer nrBooks) {
        this.Name = name;
        this.address = address;
        this.nrBooks = nrBooks;
    }

    public PublishingHouseInput() {
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
}
