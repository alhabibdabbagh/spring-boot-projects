package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/16/21 - 11:56 AM
 */
public class SameCustomerException extends RuntimeException {
    public SameCustomerException(String message) {
        super(message);
    }
}
