package com.employee.employeemanagementsystem.controller;

import com.employee.employeemanagementsystem.model.Department;
import com.employee.employeemanagementsystem.model.Employee;
import com.employee.employeemanagementsystem.repository.DepartmentRepository;
import com.employee.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(201).body(savedEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Employee employee = employeeRepository.findById(id).get();
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartment().getId()).orElse(null);
        if (department != null) {
            employee.setDepartment(department);
        } else {
            return ResponseEntity.badRequest().build();
        }

        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<Employee> searchEmployeeByEmail(@RequestParam String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }
}
