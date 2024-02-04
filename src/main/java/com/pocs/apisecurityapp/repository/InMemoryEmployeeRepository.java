package com.pocs.apisecurityapp.repository;

import com.pocs.apisecurityapp.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();
    static {
        DATABASE.add(new Employee(1, "Raj", "Patil", "raj.patil@gmail.com"));
        DATABASE.add(new Employee(2, "John", "Doe", "john.doe@gmail.com"));
        DATABASE.add(new Employee(3, "Jane", "Smith", "jane.smith@gmail.com"));
        DATABASE.add(new Employee(4, "Alice", "Johnson", "alice.johnson@gmail.com"));
    }
    public void addEmployee(Employee employee) {
        DATABASE.add(employee);
    }
    public List<Employee> getAllEmployee() {
        return List.copyOf(DATABASE);
    }
    public Employee findById(Integer empId) {
        return DATABASE
                .stream()
                .filter(employee -> empId.equals(employee.getEmpId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("can't find employee, employee id not present : " + empId));

    }
    public void updateEmployee(Employee employee) {
        Employee emp = DATABASE
                .stream()
                .filter(em -> employee.getEmpId().equals(em.getEmpId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("can't delete employee, employee id not present : " + employee.getEmpId()));
        emp.setFirstname(employee.getFirstname());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
    }
    public Boolean deleteById(Integer empId) {
        Employee emp = DATABASE
                .stream()
                .filter(em -> empId.equals(em.getEmpId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("can't delete employee, employee id not present : " + empId));
        DATABASE.remove(emp);
        return TRUE;
    }
}
