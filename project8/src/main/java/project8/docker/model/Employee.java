package project8.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Habib
 * @on 10/10/21 - 10:33 AM
 */
@Data
@AllArgsConstructor
@Document
public class Employee {

    @Id
    private String id;
    private String fullName;
    private int age;
    private double salary ;
    private List<Course> courseList =new ArrayList<>();
    private Gender gender;
    private  long ssid;
    public enum Gender{
        MALE,FEMALE
    }

    public Employee(String fullName, int age, double salary,
                    List<Course> courseList, Gender gender, long ssid) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        this.courseList = courseList;
        this.gender = gender;
        this.ssid = ssid;
    }
}
