package project7.security7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Habib
 * @on 10/14/21 - 1:00 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long id ;
    private String firstName;
    private String lastName;
    private long ssid;
    private String email;
}
