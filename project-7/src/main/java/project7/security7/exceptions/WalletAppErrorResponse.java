package project7.security7.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Habib
 * @on 10/24/21 - 1:58 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletAppErrorResponse {
    private int status;//int
    private String massage;
    private long timesTamp;
}
