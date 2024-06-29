package com.example.crud.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.Employee.Employee;
import com.example.crud.Employee.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
     * curl -X GET http://localhost:8080/employee
     */
    @GetMapping("/employee")
    public List<Employee> listAllEmployee() {
        return employeeService.listAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    

    /*
     * curl -X POST -H "Content-Type: application/json" -d '{"name": "Boss", "department": "IT", "salary": 20000}' http://localhost:8080/employee
     */
    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee) {
        //TODO: process POST request
        employeeService.addEmployee(employee);
        return "Employee Added";
    }

    /*
     * curl -X POST -H "Content-Type: application/json" -d '{"name": "Boss", "department": "IT", "salary": 20000}' http://localhost:8080/employee
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        //TODO: process PUT request
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.deleteEmpolyeeById(id);
    }
    
}
