package project7.security7.util;

import org.apache.logging.log4j.message.StringFormattedMessage;
import project7.security7.exceptions.ParseTimeException;

import javax.swing.text.StyledEditorKit;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static project7.security7.util.ErrorMassageConstants.DATE_FORMAT_WRONG;

/**
 * @author Habib
 * @on 10/23/21 - 5:57 PM
 */
public class VaildateWallet {

    public static boolean validateBalance(double balance){
        if(balance>0){
            return true;
        }
        return false;
    }

    public static void vaildateTransactionDate(String transactionDate, DateTimeFormatter dateTimeFormatter) {
        try{
            LocalDate.parse(transactionDate,dateTimeFormatter);
        }catch (DateTimeParseException e){
            throw  new ParseTimeException(String.format(DATE_FORMAT_WRONG+transactionDate));
        }

    }
}
