package com.pocs.apisecurityapp.service.impl;

import com.pocs.apisecurityapp.model.Employee;
import com.pocs.apisecurityapp.model.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmployeeDTOMapper implements Function<Employee, EmployeeDTO> {
    @Override
    public EmployeeDTO apply(Employee employee) {
        return new EmployeeDTO(
                employee.getEmpId(),
                employee.getFirstname(),
                employee.getLastName(),
                employee.getEmail());
    }
}
