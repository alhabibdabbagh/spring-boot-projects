package project7.security7.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project7.security7.entity.Customer;
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
    @ApiModelProperty(hidden = true)
   private long ssid;
/*    private LocalDate createDate;*/
    private long customerId;
}
