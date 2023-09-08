package com.example.Springmongo.dto;

import lombok.Data;


@Data
public class EmployeeDto
{

    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Boolean isActive;
}
