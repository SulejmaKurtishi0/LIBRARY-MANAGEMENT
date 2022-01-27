package com.example.demo.pojo.input;

public class BookInput {
    private String title;
    private String author;
    private String availability;

    public BookInput(String title, String author, String availability) {
        this.title = title;
        this.author = author;
        this.availability = availability;
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

    public BookInput() {
    }
}
