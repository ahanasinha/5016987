package com.employee.employeemanagementsystem.repository;

import com.employee.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(name = "Employee.findByName")
    List<Employee> findByName(@Param("name") String name);

    @Query(name = "Employee.findByEmail")
    Employee findByEmail(@Param("email") String email);
}
