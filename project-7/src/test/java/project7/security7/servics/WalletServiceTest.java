package project7.security7.servics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Wallet;
import project7.security7.mapper.WalletMapper;
import project7.security7.repository.WalletRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {
    @InjectMocks
    private WalletService walletService;

    @Mock
    private WalletMapper walletMapperMock;

    @Mock
    private WalletRepository walletRepositoryMock;


    @Test
    void saveWallet() {
        //given
        Wallet expected=new Wallet();
        WalletDTO walletDTO=new WalletDTO();
        Optional<Wallet> walletO= Optional.of(expected);

        OngoingStubbing<Wallet> wallet=  Mockito.when(walletMapperMock.fromWalletDTOToWallet(any())).thenReturn(expected);

       Wallet expectedd= (Wallet)Mockito.when(walletRepositoryMock.save(any())).thenReturn(walletO);

        //when
        Optional<Wallet> actaul = this.walletService.saveWallet(walletDTO);

        //then
        assertEquals(actaul,expectedd);

    }
}