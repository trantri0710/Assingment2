package com.example.assignment2_TranNgocTri.service.impl;

import com.example.assignment2_TranNgocTri.model.Employee;
import com.example.assignment2_TranNgocTri.repository.EmployeeRepository;
import com.example.assignment2_TranNgocTri.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long employeeId) {
        // Tìm nhân viên theo ID, ném ra ngoại lệ nếu không tìm thấy
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Khong tim thay nhan vien voi id: " + employeeId));
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByEmployee(Long employeeId, Pageable pageable) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        return employeeRepository.findByEmployeeId(employeeId,pageable);
    }


}



