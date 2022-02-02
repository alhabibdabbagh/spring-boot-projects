package project8.docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Habib
 * @on 2/2/22 - 7:48 PM
 */
@Data
@AllArgsConstructor
public class Course {

    private String courseName;
    private LocalDate courceFinishDate;

}
