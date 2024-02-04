package com.pocs.apisecurityapp.service.impl;

import com.pocs.apisecurityapp.model.Employee;
import com.pocs.apisecurityapp.repository.InMemoryEmployeeRepository;
import com.pocs.apisecurityapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        inMemoryEmployeeRepository.addEmployee(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee findById(Integer empId) {
        return inMemoryEmployeeRepository.findById(empId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer empId) {
        return inMemoryEmployeeRepository.deleteById(empId);
    }
}
