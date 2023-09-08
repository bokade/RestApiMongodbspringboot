package com.example.Springmongo.service.impl;

import com.example.Springmongo.dto.EmployeeDto;
import com.example.Springmongo.model.Employee;
import com.example.Springmongo.repository.EmployeeRepository;
import com.example.Springmongo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getEmployeeListByName(String name) {
        return employeeRepository.findByNameByQueryOperator(name);
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
        Employee employee = getEmployeeById(employeeDto.getId());
        BeanUtils.copyProperties(employeeDto,employee);
        return employeeRepository.save(employee);
    }



    @Override
    public void deleteEmployeeById(Long id) {
       employeeRepository.deleteById(id);

    }
}
