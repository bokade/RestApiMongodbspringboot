package com.example.Springmongo.controller;

import com.example.Springmongo.dto.EmployeeDto;
import com.example.Springmongo.model.Employee;
import com.example.Springmongo.service.EmployeeService;
import com.example.Springmongo.service.impl.EmployeeMongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController
{
    //for mongo repository
    //private EmployeeService employeeService;

    //for mongo template
    private EmployeeMongoTemplateService employeeService;

    //for mongo repository
//    @Autowired
//    public EmployeeController(EmployeeService employeeService)
//    {
//        this.employeeService = employeeService;
//    }
    //for mongo template
    @Autowired
    public EmployeeController(EmployeeMongoTemplateService employeeService)
    {
        this.employeeService = employeeService;
    }
     
    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto)
   {
       Employee employee = employeeService.createEmployee(employeeDto);
       return ResponseEntity.ok(employee);
   }

   @GetMapping("get") //
    public ResponseEntity<Employee> findEmployeeById(@RequestParam("id") Long id)
   {
       Employee employee =employeeService.getEmployeeById(id);
       return ResponseEntity.ok(employee);
   }

    @GetMapping("getAll") //
    public ResponseEntity<List<Employee>> findEmployeeById(@RequestParam("name") String name)
    {
        List<Employee> employees =employeeService.getEmployeeListByName(name);
        return ResponseEntity.ok(employees);
    }

    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto)
    {
        Employee employee = employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") Long id)
    {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }


}
