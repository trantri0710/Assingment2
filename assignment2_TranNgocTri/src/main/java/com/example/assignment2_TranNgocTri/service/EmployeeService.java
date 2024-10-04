package com.example.assignment2_TranNgocTri.service;

import com.example.assignment2_TranNgocTri.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    //phuong thuc lay tat ca nhan vien
   List<Employee> findAll();

   //phuong thuc save nhan vien
    Employee save(Employee employee);

    // Phương thức tìm nhân viên theo ID
    Employee findById(Long employeeId);


    Page<Employee> findAll(Pageable pageable);

   Page<Employee>findByEmployee(Long employeeId , Pageable pageable);


}
