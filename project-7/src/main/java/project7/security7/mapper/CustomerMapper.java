package project7.security7.mapper;

import org.mapstruct.Mapper;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;

@Mapper
public interface CustomerMapper {
     Customer mapFromCustomerDTOToCustomer(CustomerDTO customerDTO);
     CustomerDTO mapFromCustomerToCustomerDTO(Customer customer);
}
