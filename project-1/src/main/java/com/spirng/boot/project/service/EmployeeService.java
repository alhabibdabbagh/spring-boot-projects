package com.spirng.boot.project.service;



import com.spirng.boot.project.entity.Employee;
import com.spirng.boot.project.repository.EmployeeRepository;
import com.spirng.boot.project.repository.GroupWithAgeAndCount;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Habib
 * @on 9/24/21 - 8:42 AM
 */
@Service
//@RequiredArgsConstructor
public class EmployeeService implements BaseService<Employee> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        List<Employee> employeeList=new ArrayList<>();
        Iterable<Employee> employees  =employeeRepository.findAll();
        employees.iterator().forEachRemaining(employeeList::add);
        return employeeList;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(int id) {
        Optional<Employee> employees =employeeRepository.findById(id);

        return employees.get();
    }

    @Override
    public String save(Employee object) {
      Employee employee=  employeeRepository.save(object);
        return "S";
    }

    @Override
    @Transactional()
    public void deleteById(int id) {
employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
       // employee.
        return employeeRepository.save(employee);
    }

    public int getAllEmployeeCount() {
        // employee.
        return employeeRepository.getAllEmployeeCount();
    }

    public List<GroupWithAgeAndCount> getGroup() {
        return employeeRepository.getGroup();
    }

    public List<?> getGroupWith() {
        return employeeRepository.getGroupWith();
    }
}
