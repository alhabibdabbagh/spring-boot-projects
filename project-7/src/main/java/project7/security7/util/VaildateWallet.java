package project7.security7.util;

import javax.swing.text.StyledEditorKit;

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
}
