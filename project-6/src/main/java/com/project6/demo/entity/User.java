package com.project6.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Habib
 * @on 10/10/21 - 12:11 PM
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // bu initialize yaptıktan sonra bi ilk değer atama yapmak için kullanır initializerRunner'da
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private int age;
    private String email;
}
