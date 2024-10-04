package com.example.assignment2_TranNgocTri.service.impl;


import com.example.assignment2_TranNgocTri.model.Department;
import com.example.assignment2_TranNgocTri.model.Employee;
import com.example.assignment2_TranNgocTri.repository.DepartmentRepository;
import com.example.assignment2_TranNgocTri.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

//    @Override
//    public Department save(Department department) {
//        return departmentRepository.save(department);
//    }
}
