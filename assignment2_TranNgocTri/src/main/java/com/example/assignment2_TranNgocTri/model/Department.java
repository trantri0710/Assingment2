package com.example.assignment2_TranNgocTri.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @NotBlank(message = "ten phong ban khong duoc de trong !!!")
    @Column(name = "department_name", unique = true , nullable = false)
    @Size(min = 5 , max = 30 , message = "Ten phong ban phai tu 5 den 30 ki tu !!!")
    private String departmentName;

    @Column(name = "location")
    @NotBlank(message = "dia chi khong duoc de trong !!!")
    private String location;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();
}
