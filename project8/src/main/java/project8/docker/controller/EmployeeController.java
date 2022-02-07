package project8.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project8.docker.model.Employee;
import project8.docker.service.EmployeeService;

import java.util.List;

/**
 * @author Habib
 * @on 2/7/22 - 11:04 AM
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();

    }
}
