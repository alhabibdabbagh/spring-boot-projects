package project7.security7.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Habib
 * @on 10/14/21 - 11:27 AM
 */
@MappedSuperclass
@Data
public abstract class AbstractIdBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
