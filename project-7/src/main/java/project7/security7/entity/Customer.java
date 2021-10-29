package project7.security7.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Habib
 * @on 10/14/21 - 11:18 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends AbstractIdBase  {

    private String firstName;
    private String lastName;
    private long ssid;
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
   private List<Wallet> walletList=new ArrayList<>();


}
