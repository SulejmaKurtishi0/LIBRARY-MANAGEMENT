package com.example.demo.controller;
import com.example.demo.pojo.Employee;

import com.example.demo.pojo.input.EmployeeInput;

import com.example.demo.service.DefaultEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private DefaultEmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee insertNewEmployee(@RequestBody EmployeeInput employeeInput) {
        return employeeService.save(employeeInput);
    }

    @PutMapping("/employee/{id}")
    public Employee updateBook(@PathVariable Integer id,
                               @RequestBody EmployeeInput employeeInput) {
        return employeeService.update(id,employeeInput);
    }

    @DeleteMapping("/employee/{id}")
    public Boolean deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return true;
    }
}
