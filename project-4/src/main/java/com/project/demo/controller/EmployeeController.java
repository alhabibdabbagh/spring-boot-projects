package com.project.demo.controller;

import com.project.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Habib
 * @on 10/10/21 - 10:34 AM
 */
@Controller
// thymeleaf kullandığımız zaman her zaman @controller annotion'ı kullanacaız @restController değil . farkı nedir ?? //TODO
@RequestMapping("/api")
public class EmployeeController {

    private List<Employee> employeeList;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @PostConstruct
    private void locaDate() {
        employeeList = Arrays.asList(
                new Employee(atomicInteger.incrementAndGet(), "habib", 23, 4545.22),
                new Employee(atomicInteger.incrementAndGet(), "hasan", 25, 4845.33),
                new Employee(atomicInteger.incrementAndGet(), "mahmut", 55, 4548.88)
        );
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeList);
        return "employees";
    }

}
