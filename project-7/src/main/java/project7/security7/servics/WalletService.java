package project7.security7.servics;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Customer;
import project7.security7.entity.Wallet;
import project7.security7.entity.WalletServiceTranscationLogger;
import project7.security7.enumuration.Currency;
import project7.security7.enumuration.TranscationType;
import project7.security7.exceptions.BadRequestException;
import project7.security7.exceptions.NoEnoughBalanceForWithdrawException;
import project7.security7.exceptions.NotFoundCurrnecyForCustomer;
import project7.security7.exceptions.isAlreadyHasWallet;
import project7.security7.mapper.WalletMapper;
import project7.security7.repository.CustomerDAO;
import project7.security7.repository.TranscationLoggerRepository;
import project7.security7.repository.WalletRepository;
import project7.security7.util.ClientRequestInfo;
import project7.security7.util.ErrorMassageConstants;
import project7.security7.util.VaildateWallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TranscationLoggerRepository transcationLoggerRepository;

    public Customer findCustomerById(long id) {
        if (customerDAO.findById(id).isPresent()) {
            return customerDAO.findById(id).get();
        }
        throw new RuntimeException("we cann't find the customer with this ID : " + id); // ikinci yazma şekli
        //  return customerDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("we cann't find the customer with this ID %d", id)));
    }

    public Optional<Wallet> saveWallet(WalletDTO walletDTO) {
        this.vaildateForBalance(walletDTO.getBalance());
        this.vaildateForSameCustomerWithDiffrentCurrnecy(walletDTO.getCustomerId(), walletDTO.getCurrency());
        //mapping
        Wallet wallet = walletMapper.fromWalletDTOToWallet(walletDTO);
        return Optional.ofNullable(walletRepository.save(wallet));
    }

    private void vaildateForSameCustomerWithDiffrentCurrnecy(long customerId, Currency currency) {
        if (walletRepository.isExitCurrencyForSameCustomer(currency, customerId)) {
            throw new isAlreadyHasWallet(ErrorMassageConstants.EXIT_WALLET);
        }
    }

    private void vaildateForBalance(double balance) {
        if (!VaildateWallet.validateBalance(balance)) {
            throw new BadRequestException(ErrorMassageConstants.BALANCE_IS_MINUS);
        }
    }

    @Transactional
    public Optional<Wallet> deposit(long customerId, String currency, double amount) {
        Optional<Wallet> optionalWallet = getWallet(customerId, currency);
/*        if (!optionalWallet.isPresent()) {
            throw new NotFoundCurrnecyForCustomer(ErrorMassageConstants.NOT_FOUND_CURRENCY_FOR_CUSTOMER);

        }*/
        optionalWallet.get().setBalance(optionalWallet.get().getBalance() + amount);
        walletRepository.save(optionalWallet.get());
        this.saveTranscationToDatabase(optionalWallet.get(), amount, TranscationType.DEPOSIT);
        return optionalWallet;
    }

    private void saveTranscationToDatabase(Wallet wallet, double amount, TranscationType transcationType) {
        WalletServiceTranscationLogger walletServiceTranscationLogger = new WalletServiceTranscationLogger();
        if (transcationType.equals(TranscationType.DEPOSIT)) {
            walletServiceTranscationLogger.setBeforBalance(wallet.getBalance() - amount);

        } else {
            walletServiceTranscationLogger.setBeforBalance(wallet.getBalance() + amount);

        }
        walletServiceTranscationLogger.setAfterBalance(wallet.getBalance());
        walletServiceTranscationLogger.setCustomerId(wallet.getCustomer().getId());
        walletServiceTranscationLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        walletServiceTranscationLogger.setClientUrl(clientRequestInfo.getClientUrl());
        walletServiceTranscationLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        walletServiceTranscationLogger.setTranscationAmount(amount);
        walletServiceTranscationLogger.setTranscationCurrency(wallet.getCurrency());
        walletServiceTranscationLogger.setTranscatiınDataTime(LocalDate.now());
        walletServiceTranscationLogger.setTranscationType(transcationType);
        transcationLoggerRepository.save(walletServiceTranscationLogger);
    }

    private Optional<Wallet> getWallet(long customerId, String currency) throws NotFoundCurrnecyForCustomer {
        Customer customer = findCustomerById(customerId);
        Optional<Wallet> optionalWallet = customer.getWalletList()
                .stream()
                .filter(wallet -> wallet.getCurrency().equals(Currency.valueOf(currency)))
                .findFirst();
        if (optionalWallet.isPresent()) {
            return optionalWallet;
        }
        throw new NotFoundCurrnecyForCustomer(ErrorMassageConstants.NOT_FOUND_CURRENCY_FOR_CUSTOMER);
    }

    @Transactional
    public Optional<Wallet> Withdraw(long customerId, String currency, double mins) {
        Optional<Wallet> optionalWallet = getWallet(customerId, currency);
        if (!optionalWallet.isPresent() || optionalWallet.get().getBalance() < mins) {
            throw new NoEnoughBalanceForWithdrawException(ErrorMassageConstants.NO_ENOUGH_BALANCE);

        }
        optionalWallet.get().setBalance(optionalWallet.get().getBalance() - mins);
        walletRepository.save(optionalWallet.get());
        this.saveTranscationToDatabase(optionalWallet.get(), mins, TranscationType.WITHDRAW);
        return optionalWallet;
    }

    public Page<List<WalletServiceTranscationLogger>> getAllTransactionsWithDate(String transactionDate, Pageable pageable) {
         DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("d/MM/yyyy");
    VaildateWallet.vaildateTransactionDate(transactionDate,dateTimeFormatter);

       LocalDate dataTranscationResult= LocalDate.parse(transactionDate,dateTimeFormatter);

        return this.transcationLoggerRepository.findTreanscationAboutDate(dataTranscationResult,pageable);
    }
}
