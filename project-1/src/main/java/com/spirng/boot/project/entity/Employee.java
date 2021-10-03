package com.spirng.boot.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Habib
 * @on 9/27/21 - 8:32 AM
 */
@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String fullName;
    private int age;
    private double salary ;
}
