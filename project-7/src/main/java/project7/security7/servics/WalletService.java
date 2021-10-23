package project7.security7.servics;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Customer;
import project7.security7.entity.Wallet;
import project7.security7.enumuration.Currency;
import project7.security7.exceptions.BadRequestException;
import project7.security7.exceptions.isAlreadyHasWallet;
import project7.security7.mapper.WalletMapper;
import project7.security7.repository.CustomerDAO;
import project7.security7.repository.WalletRepository;
import project7.security7.util.ErrorMassageConstants;
import project7.security7.util.VaildateWallet;

import java.util.Optional;

/**
 * @author Habib
 * @on 10/17/21 - 11:41 AM
 */
@Service
@RequiredArgsConstructor
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private WalletMapper walletMapper;
    @Autowired
    private CustomerDAO customerDAO;

    public Customer findCustomerById(long id) {
/*        if(customerDAO.findById(id).isPresent()){
            return customerDAO.findById(id).get();
        }
        throw new RuntimeException("we cann't find the customer with this ID : "+ id);*/ // ikinci yazma şekli
        return customerDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("we cann't find the customer with this ID %d", id)));
    }

    public Optional<Wallet> saveWallet(WalletDTO walletDTO) {
        this.vaildateForBalance(walletDTO.getBalance());
        this.vaildateForSameCustomerWithDiffrentCurrnecy(walletDTO.getCustomerId(),walletDTO.getCurrency());


        //mapping
        Wallet wallet = walletMapper.fromWalletDTOToWallet(walletDTO);

        return Optional.ofNullable(walletRepository.save(wallet));
    }

    private void vaildateForSameCustomerWithDiffrentCurrnecy(long customerId, Currency currency) {
        if(walletRepository.isExitCurrencyForSameCustomer(currency,customerId)){
            throw  new isAlreadyHasWallet(ErrorMassageConstants.EXIT_WALLET);
        }

    }

    private void vaildateForBalance(double balance) {
        if(!VaildateWallet.validateBalance(balance)){
            throw  new BadRequestException(ErrorMassageConstants.BALANCE_IS_MINUS);
        }
    }
}
