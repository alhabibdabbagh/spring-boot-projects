package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/27/21 - 7:58 PM
 */
public class NotFoundCurrnecyForCustomer  extends RuntimeException{
    public NotFoundCurrnecyForCustomer(String message) {
        super(message);
    }
}
