package project2.h2project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Habib
 * @on 10/5/21 - 11:38 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends TodoBaseRequest {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todoId;
    private int userId;
    private int Id;
    private String title;
    private boolean complated;
}
