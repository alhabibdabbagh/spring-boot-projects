package project7.security7.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Wallet;
import project7.security7.entity.WalletServiceTranscationLogger;
import project7.security7.servics.WalletService;

import javax.validation.Valid;
import java.util.List;
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
    @PutMapping("/mins/{customerId}/{currency}/{mins}")
    public ResponseEntity<Wallet> depositToWalletMins(@PathVariable long customerId
            , @PathVariable("currency") String currency
            , @PathVariable double mins){
        Optional <Wallet> optionalWallet= walletService.Withdraw(customerId,currency,mins);
        if(optionalWallet.isPresent()){
            return new ResponseEntity<>(optionalWallet.get() , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
      @GetMapping("/get-transacton/by-date")
    public ResponseEntity <Page<List<WalletServiceTranscationLogger>>> getAllTranscation(
              @ApiParam(value = "transcation query for wallet usage",example = "05/07/2021",required = true)
            @RequestParam String transactionDate, @PageableDefault(page = 0,size = 10)Pageable pageable,
              @RequestParam(required = false) Integer pageSize,
              @RequestParam(required = false) Integer pageNumber){
      /* if( Optional.ofNullable(pageNumber).isPresent() && Optional.ofNullable(pageSize).isPresent() )*/
        return new ResponseEntity<>(this.walletService.getAllTransactionsWithDate(transactionDate,pageable,pageSize,pageNumber),HttpStatus.OK);
  /*        return new ResponseEntity<>(this.walletService.getAllTransactionsWithDate(transactionDate,pageable,null,null),HttpStatus.OK);*/
      }

}
