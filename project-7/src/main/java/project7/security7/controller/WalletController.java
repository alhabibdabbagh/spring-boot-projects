package project7.security7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Wallet;
import project7.security7.enumuration.Currency;
import project7.security7.servics.WalletService;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Habib
 * @on 10/17/21 - 11:45 AM
 */
@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping ("/save/wallet")
    public ResponseEntity<Wallet> saveWallet(@RequestBody @Valid WalletDTO walletDTO){
      Optional <Wallet> optionalWallet= walletService.saveWallet(walletDTO);
      if(optionalWallet.isPresent()){
          return new ResponseEntity<>(optionalWallet.get() , HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/deposit/{customerId}/{currency}/{amount}")
    public ResponseEntity<Wallet> depositToWallet(@PathVariable long customerId
            , @PathVariable("currency") String currency
            , @PathVariable double amount){
        Optional <Wallet> optionalWallet= walletService.deposit(customerId,currency,amount);
        if(optionalWallet.isPresent()){
            return new ResponseEntity<>(optionalWallet.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
