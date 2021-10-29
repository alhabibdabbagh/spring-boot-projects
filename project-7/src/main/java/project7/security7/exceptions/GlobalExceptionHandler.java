package project7.security7.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Habib
 * @on 10/24/21 - 1:54 PM
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<WalletAppErrorResponse> handleException(BadRequestException e) {
        WalletAppErrorResponse walletAppErrorResponse = prepareErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(walletAppErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({isAlreadyHasWallet.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<WalletAppErrorResponse> handleException(isAlreadyHasWallet e) {
        WalletAppErrorResponse walletAppErrorResponse = prepareErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(walletAppErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SameCustomerException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<WalletAppErrorResponse> handleException(SameCustomerException e) {
        WalletAppErrorResponse walletAppErrorResponse = prepareErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(walletAppErrorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({NotFoundCurrnecyForCustomer.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<WalletAppErrorResponse> handleException(NotFoundCurrnecyForCustomer e) {
        WalletAppErrorResponse walletAppErrorResponse = prepareErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(walletAppErrorResponse, HttpStatus.NOT_FOUND);
    }
    private WalletAppErrorResponse prepareErrorResponse(HttpStatus httpStatus, String massage) {
        WalletAppErrorResponse walletAppErrorResponse = new WalletAppErrorResponse();
        walletAppErrorResponse.setMassage(massage);
        walletAppErrorResponse.setStatus(httpStatus.value());
        walletAppErrorResponse.setTimesTamp(System.currentTimeMillis());
        return walletAppErrorResponse;
    }
}
