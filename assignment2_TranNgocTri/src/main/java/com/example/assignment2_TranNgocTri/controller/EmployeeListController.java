package com.example.assignment2_TranNgocTri.controller;

import com.example.assignment2_TranNgocTri.model.Employee;
import com.example.assignment2_TranNgocTri.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeListController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(value = "/employee/list")
    public String showEmployeeList(Model model, @RequestParam(required = false) Long employeeId
    ,                                           @RequestParam(required = false, defaultValue = "1") Integer currentPage,
                                                @RequestParam(required = false, defaultValue = "5") Integer maxRecord) {

    Sort sort = Sort.by("jobTitle").descending();
    Pageable pageable = PageRequest.of(currentPage - 1, maxRecord, sort);
    Page<Employee> employeePage = null;

    // Kiểm tra employeeId
    if (employeeId == null) {
        employeePage = employeeService.findAll(pageable);
    } else {
        employeePage = employeeService.findByEmployee(employeeId, pageable);
    }



//     Thêm thông tin phân trang vào model
    model.addAttribute("employeeList", employeePage.getContent());
    model.addAttribute("totalPage", employeePage.getTotalPages());
    model.addAttribute("currentPage", currentPage);
    model.addAttribute("maxRecord", maxRecord);


        model.addAttribute("employees",employeeService.findAll());


    return "employee_list"; // Trả về trang HTML có tên là employee_list

}



//
    @GetMapping("/employee/details/{employeeId}")
    public String getEmployeeDetails(@PathVariable Long employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employee_details"; // Trả về trang chi tiết nhân viên
    }


}






