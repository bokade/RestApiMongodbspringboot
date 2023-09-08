package com.example.Springmongo;

import com.example.Springmongo.model.Employee;
import com.example.Springmongo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringmongodbApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	void printEmployee(List<Employee> employeesList)
	{
		employeesList.forEach(System.out::println);
	}

	@Test
	void employeeGreaterThan(){
		List<Employee> employees = employeeRepository.findEmployeeGreaterThan(10000.0);
		printEmployee(employees);
	}
	@Test
	void employeeLessThan(){
		List<Employee> employees = employeeRepository.findEmployeeLessThan(15000.0);
		printEmployee(employees);
	}

	@Test
	void employeeBetween(){
		List<Employee> employees = employeeRepository.findEmployeeBetween(10000.0,15000.0);
		printEmployee(employees);
	}



}
