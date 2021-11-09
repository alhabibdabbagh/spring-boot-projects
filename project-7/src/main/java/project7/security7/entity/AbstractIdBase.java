package project7.security7.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author Habib
 * @on 10/14/21 - 11:27 AM
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractIdBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreatedDate
/*    @Column(name = "created_date")*/
    @JsonIgnore// mappleme olmasın diye çünkü otomatik generated olacak
    private Instant createdTime =Instant.now();

    @LastModifiedDate
 /*   @Column(name = "modified_date")*/
    @JsonIgnore
    private Instant modifiedDate =Instant.now();
}
