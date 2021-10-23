package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/23/21 - 6:32 PM
 */
public class isAlreadyHasWallet extends RuntimeException {
    public isAlreadyHasWallet(String message) {
        super(message);
    }
}
