package com.example.assignment2_TranNgocTri.repository;

import com.example.assignment2_TranNgocTri.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


//    Page<Employee> findByEmployeeId(Long Employee , Pageable pageable);
Page<Employee> findByEmployeeId(Long employeeId, Pageable pageable);
}
