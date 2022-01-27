package com.example.demo.pojo.input;

public class EmployeeInput {
    private String name;
    private String surname;
    private Integer workingHours;

    public EmployeeInput(String name, String surname, Integer workingHours) {
        this.name = name;
        this.surname = surname;
        this.workingHours = workingHours;
    }

    public EmployeeInput() {
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
}
