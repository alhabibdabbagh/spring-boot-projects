package project2.h2project.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Habib
 * @on 10/5/21 - 11:47 PM
 */
@Data
@MappedSuperclass
public class TodoBaseRequest {
    private LocalDateTime localDateTime;
}
