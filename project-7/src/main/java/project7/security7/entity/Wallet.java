package project7.security7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project7.security7.enumuration.Currency;

import javax.persistence.Entity;

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


    private Currency currency;
    private  double balance;
    private LocalDate createDate;

}
