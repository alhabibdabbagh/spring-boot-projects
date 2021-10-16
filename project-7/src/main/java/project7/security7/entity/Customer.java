package project7.security7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Habib
 * @on 10/14/21 - 11:18 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends AbstractIdBase {

    private String firstName;
    private String lastName;
    private long ssid;
    private String email;


}
