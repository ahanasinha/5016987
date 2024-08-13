package com.employee.employeemanagementsystem.repository;

import com.employee.employeemanagementsystem.dto.DepartmentSummary;
import com.employee.employeemanagementsystem.dto.DepartmentSummaryProjection;
import com.employee.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(name = "Department.findByName")
    Department findByName(@Param("name") String name);

    @Query("SELECT d.name AS name, SIZE(d.employees) AS employeeCount " +
            "FROM Department d")
    List<DepartmentSummaryProjection> findDepartmentSummaryProjections();

    @Query("SELECT new com.employee.employeemanagementsystem.dto.DepartmentSummary(d.id, d.name) FROM Department d")
    List<DepartmentSummary> findDepartmentSummaries();
}
