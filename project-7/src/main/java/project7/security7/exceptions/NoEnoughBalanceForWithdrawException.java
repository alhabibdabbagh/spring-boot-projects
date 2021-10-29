package project7.security7.exceptions;

/**
 * @author Habib
 * @on 10/29/21 - 10:57 AM
 */
public class NoEnoughBalanceForWithdrawException extends RuntimeException {
    public NoEnoughBalanceForWithdrawException(String message) {
        super(message);
    }
}
