package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/23/21 - 5:24 PM
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

}
