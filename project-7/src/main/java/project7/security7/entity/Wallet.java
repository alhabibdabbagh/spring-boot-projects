package project7.security7.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project7.security7.enumuration.Currency;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Habib
 * @on 10/14/21 - 11:18 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet extends AbstractIdBase {

    @Enumerated(EnumType.STRING) // string olarak kayiddecek DB 'de
    private Currency currency;
    private  double balance;
    private LocalDate createDate;
  //  private Customer customer;

    @JsonBackReference
    @ManyToOne
     private Customer customer;

}
