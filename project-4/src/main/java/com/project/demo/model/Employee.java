package com.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Habib
 * @on 10/10/21 - 10:33 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String fullName;
    private int age;
    private double salary ;
}
