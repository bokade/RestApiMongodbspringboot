package com.example.Springmongo.service;

import com.example.Springmongo.dto.EmployeeDto;
import com.example.Springmongo.model.Employee;

import java.util.List;

public interface EmployeeService
{
    Employee createEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(Long id);
    List<Employee> getEmployeeListByName(String name);
    Employee updateEmployee(EmployeeDto employeeDto);

    void deleteEmployeeById(Long id);
}
