package com.example.assignment2_TranNgocTri.controller;

import com.example.assignment2_TranNgocTri.model.Department;
import com.example.assignment2_TranNgocTri.model.Employee;
import com.example.assignment2_TranNgocTri.repository.DepartmentRepository;
import com.example.assignment2_TranNgocTri.repository.EmployeeRepository;
import com.example.assignment2_TranNgocTri.service.DepartmentService;
import com.example.assignment2_TranNgocTri.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EmployeeFormController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/employee/form")
    public String showFormEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("departmentList" , departmentService.findAll());
        return "employee_form";
    }


    @GetMapping(value = "/employee/new")
    public String addNewEmployee(Model model){
        model.addAttribute("employee" , new Employee());
        model.addAttribute("departmentList" , departmentService.findAll());
        return "employee_form";
    }


    @PostMapping(value = "/employee/save")
    public String saveEmployee(@Valid  @ModelAttribute("employee")  Employee employee, BindingResult bindingResult
    , Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("departmentList",departmentService.findAll());
            model.addAttribute("employee", employee);

            return "employee_form";
        }

        employeeService.save(employee);

        return "redirect:/employee/list";
    }




    @GetMapping(value = "/employee/form/{employeeId}")
    public String showForm(Model model , @PathVariable(name = "employeeId") Long employeeId ){

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

        model.addAttribute("employee" , optionalEmployee.get());
        model.addAttribute("departmentList" , departmentRepository.findAll());
        return "employee_form";
    }
}
