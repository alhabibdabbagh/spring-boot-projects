package com.project6.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    @NotBlank(message = "the name is mandatory")
    private String name;
    @Min(value = 18,message = "age can't be yonger then 18")
    @Max(value = 120,message = "age cann't be gerater then 120")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int age;
    @Email(message = "the email is mandatory")
    @NotBlank(message = "the name is mandatory")
    private String email;
}
