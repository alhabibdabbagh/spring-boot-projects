package project7.security7.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import project7.security7.entity.Customer;
import project7.security7.enumuration.Currency;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Habib
 * @on 10/14/21 - 1:01 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {
    @ApiModelProperty(example = " TRY or USD or EUR")
    @NotNull(message = "currency is mandatory")
    private Currency currency;

    @NotNull(message = "balance is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @ApiModelProperty(example = "0.0")
    private double balance;

    @ApiModelProperty(hidden = true)
    private long ssid;
    /*    private LocalDate createDate;*/
    @NotNull(message = "customerID is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private long customerId;
}
