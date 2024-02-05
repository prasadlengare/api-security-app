package com.pocs.apisecurityapp.service;

import com.pocs.apisecurityapp.model.Employee;
import com.pocs.apisecurityapp.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    // save an employee
    Employee addEmployee(Employee employee);
    // get employee
    List<Employee> getAllEmployee();
    List<EmployeeDTO> getAllEmployeeMapper();
    // get one employee
    Employee findById(Integer empId);
    // update employee
    void updateEmployee(Employee employee);
    // delete employee
    Boolean deleteById(Integer empId);
}
