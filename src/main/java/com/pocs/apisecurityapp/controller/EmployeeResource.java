package com.pocs.apisecurityapp.controller;

import com.pocs.apisecurityapp.model.Employee;
import com.pocs.apisecurityapp.model.EmployeeDTO;
import com.pocs.apisecurityapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pocs.apisecurityapp.util.AppUtil.areAllFieldsNullOrEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping(value = "/mapper")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesMapper() {
        return ResponseEntity.ok(employeeService.getAllEmployeeMapper());
    }

    @GetMapping("{empId}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable("empId") Integer empId) {
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {
        employee.setEmpId(employeeService.getAllEmployee().size() + 1);
        employeeService.addEmployee(employee);
        //return ResponseEntity.created(getLocation(employee.getEmpId())).body(employeeService.addEmployee(employee));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{empId}")
    public ResponseEntity<Boolean> deleteEmployee(
            @PathVariable("empId") Integer empId) {
        return ResponseEntity.ok(employeeService.deleteById(empId));
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestParam("empId") Integer empId, @Valid @RequestBody Employee updatedEmp) {
        Employee existingEmp = employeeService.findById(empId);
        if (existingEmp == null) {
            return new ResponseEntity<>("Employee with ID " + empId + " not found.", HttpStatus.NOT_FOUND);
        }

        if (areAllFieldsNullOrEmpty(updatedEmp)) {
            return new ResponseEntity<>("All fields in the request body are null or empty.", HttpStatus.BAD_REQUEST);
        }
        existingEmp.setFirstname(updatedEmp.getFirstname() != null ? updatedEmp.getFirstname() : existingEmp.getFirstname());
        existingEmp.setLastName(updatedEmp.getLastName() != null ? updatedEmp.getLastName() : existingEmp.getLastName());
        existingEmp.setEmail(updatedEmp.getEmail() != null ? updatedEmp.getEmail() : existingEmp.getEmail());
        employeeService.updateEmployee(existingEmp);
        return new ResponseEntity<>("Employee with ID " + empId + " updated successfully.", HttpStatus.OK);
    }
}
