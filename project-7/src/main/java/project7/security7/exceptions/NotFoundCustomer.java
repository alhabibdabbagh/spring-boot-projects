package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/29/21 - 4:57 PM
 */
public class NotFoundCustomer extends RuntimeException {
    public NotFoundCustomer(String message) {
        super(message);
    }
}
