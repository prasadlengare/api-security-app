package com.pocs.apisecurityapp.service;

import com.pocs.apisecurityapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    // save an employee
    Employee addEmployee(Employee employee);
    // get employee
    List<Employee> getAllEmployee();
    // get one employee
    Employee findById(Integer empId);
    // update employee
    void updateEmployee(Employee employee);
    // delete employee
    Boolean deleteById(Integer empId);
}
