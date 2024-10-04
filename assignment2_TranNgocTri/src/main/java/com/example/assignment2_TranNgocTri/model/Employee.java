package com.example.assignment2_TranNgocTri.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @NotBlank(message = "ten nhan vien khong duoc de trong !!!")
    @Column(name = "employee_name" , nullable = false)
    private String employeeName;


    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;


    @NotBlank(message = "Mo ta cong viec khong duoc de trong !!!")
    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary")
    @PositiveOrZero(message = "luong phai lon hon hoac bang 0 ")
    private BigDecimal salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "status")
    private Boolean status;
}
