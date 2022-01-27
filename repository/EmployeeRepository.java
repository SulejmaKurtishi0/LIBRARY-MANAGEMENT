package com.example.demo.repository;

import com.example.demo.pojo.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findAll();
    Employee findEmployeeById(Integer id);
}