package project8.docker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project8.docker.model.Employee;
import project8.docker.repository.EmployeeRepository;

import java.util.List;

/**
 * @author Habib
 * @on 2/7/22 - 11:04 AM
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
