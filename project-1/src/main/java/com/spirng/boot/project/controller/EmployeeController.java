package com.spirng.boot.project.controller;


import com.spirng.boot.project.entity.Employee;
import com.spirng.boot.project.repository.GroupWithAgeAndCount;
import com.spirng.boot.project.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Habib
 * @on 9/24/21 - 8:41 AM
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

 private Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

        @Value("${developer.name:ALİ}*")//yıldız önemli // : default olarak ALİ alır
        private String name;

    @Value("${developer.phoneNumber:123123}*")// with new foo.properties
    private  String phoneNumber;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        logger.info("asdasdas"+name+" "+ phoneNumber);

        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){

     return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){
        return new  ResponseEntity<>(employeeService.findById(id),HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employee/{id}")
    public String deletedById(@PathVariable int id){
        employeeService.deleteById(id);
        return "deleted...";
    }
    @GetMapping("/employee/count")
    public int getAllEmployeeCount(){
        return employeeService.getAllEmployeeCount();
    }
    @GetMapping("/employee/countwithgroup")
    public List<GroupWithAgeAndCount> getGroup(){
        return employeeService.getGroup();
    }
    @GetMapping("/employee/countwith")
    public List<?> getGroup1(){
        return employeeService.getGroupWith();
    }
}
