package com.example.crud.Employee.service;

import java.util.List;

import com.example.crud.Employee.*;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> listAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee newEmployee);
    void deleteEmpolyeeById(Long id);
}
