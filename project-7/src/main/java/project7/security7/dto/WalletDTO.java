package project7.security7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project7.security7.enumuration.Currency;

import java.time.LocalDate;

/**
 * @author Habib
 * @on 10/14/21 - 1:01 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private Currency currency;
    private  double balance;
    private long ssid;
    private LocalDate createDate;
}
