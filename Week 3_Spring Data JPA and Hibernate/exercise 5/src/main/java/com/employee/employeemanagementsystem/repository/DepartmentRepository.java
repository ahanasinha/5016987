package com.employee.employeemanagementsystem.repository;

import com.employee.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(name = "Department.findByName")
    Department findByName(@Param("name") String name);
}
