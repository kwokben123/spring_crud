package com.example.crud.Employee.service;

import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.crud.Employee.entities.Employee;
import com.example.crud.Employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listAllEmployee() {
        System.out.println("listAllEmployee");
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find user with id " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee newEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setDepartment(newEmployee.getDepartment());
                    employee.setSalary(newEmployee.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @Override
    public void deleteEmpolyeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
