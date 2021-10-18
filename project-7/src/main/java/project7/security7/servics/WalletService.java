package project7.security7.servics;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Customer;
import project7.security7.entity.Wallet;
import project7.security7.mapper.WalletMapper;
import project7.security7.repository.CustomerDAO;
import project7.security7.repository.WalletRepository;

import java.util.Optional;

/**
 * @author Habib
 * @on 10/17/21 - 11:41 AM
 */
@Service
@RequiredArgsConstructor
public class WalletService {

    private  WalletRepository walletRepository;
    @Autowired
    private  WalletMapper walletMapper;

    private  CustomerDAO customerDAO;

    public Customer findCustomerById(long id){
        if(customerDAO.findById(id).isPresent()){
            return customerDAO.findById(id).get();
        }
        throw new RuntimeException("we cann't find the customer with this ID : "+ id);
    }
    public Optional<Wallet> saveWallet(WalletDTO walletDTO) {
        //mapping
        Wallet wallet = walletMapper.fromWalletDTOToWallet(walletDTO);

        return Optional.ofNullable(walletRepository.save(wallet));
    }
}
