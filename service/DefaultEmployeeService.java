package com.example.demo.service;


import com.example.demo.pojo.Employee;
import com.example.demo.pojo.input.EmployeeInput;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultEmployeeService  implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee save(EmployeeInput employeeInput) {


        String name = employeeInput.getName();
        String surname = employeeInput.getSurname();
        Integer workingHours= employeeInput.getWorkingHours();

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setWorkingHours(workingHours);

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Integer id, EmployeeInput employeeInput) {

        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee== null) {
            return null;
        }

        String updatedName = employeeInput.getName();
        String updatedSurname = employeeInput.getSurname();
        Integer updatedWorkingHours = employeeInput.getWorkingHours();

        employee.setName(updatedName);
        employee.setSurname(updatedSurname);
        employee.setWorkingHours(updatedWorkingHours);

        return employeeRepository.save(employee);
    }

    @Override
    public Boolean delete(Integer id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee!= null) {
            employeeRepository.delete(employee);
        }
 return  true;
    }


}
