package project7.security7.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import project7.security7.dto.CustomerDTO;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Wallet;
import project7.security7.servics.WalletService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    @Mock
    private WalletService walletServiceMock;

    @InjectMocks
    public WalletController walletController;

    @Test
    void saveWallet() {
        //given
        Wallet wallet=new Wallet();
        Optional<Wallet> expected= Optional.of(wallet);

        // when
        Mockito.when(walletServiceMock.saveWallet(any())).thenReturn(expected);

        //then
        WalletDTO walletDTO=new WalletDTO();
       Wallet actual=this.walletController.saveWallet(walletDTO).getBody();

       assertEquals(actual,expected.get());

    }
}