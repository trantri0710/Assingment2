package com.example.assignment2_TranNgocTri.repository;

import com.example.assignment2_TranNgocTri.model.Department;
import com.example.assignment2_TranNgocTri.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
