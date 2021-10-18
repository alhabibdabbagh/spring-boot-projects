package project7.security7.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import project7.security7.dto.WalletDTO;
import project7.security7.entity.Wallet;
import project7.security7.servics.WalletService;

@Mapper(componentModel = "spring")
public abstract class WalletMapper {

    @Autowired
    protected WalletService walletService;

    @Mapping(target = "customer", expression = "java(walletService.findCustomerById(walletDTO.getCustomerId()))")
    @Mapping(target = "createDate",expression = "java(java.time.LocalDate.now())")
    public abstract Wallet fromWalletDTOToWallet(WalletDTO walletDTO);

    public abstract WalletDTO fromWalletToWalletDTO(Wallet wallet);
}
