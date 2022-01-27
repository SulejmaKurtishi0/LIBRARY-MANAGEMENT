package com.example.demo.service;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.input.EmployeeInput;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findEmployeeById(Integer id);
    Employee save(EmployeeInput employeeInput);
    Employee update(Integer id, EmployeeInput employeeInput);
    Boolean delete(Integer id);
}

