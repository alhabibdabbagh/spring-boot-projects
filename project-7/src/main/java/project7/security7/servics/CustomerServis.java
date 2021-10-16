package project7.security7.servics;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;
import project7.security7.exceptions.SameCustomerException;
import project7.security7.mapper.CustomerMapper;
import project7.security7.repository.CustomerDAO;

import java.util.Optional;

/**
 * @author Habib
 * @on 10/14/21 - 11:32 AM
 */
@Service
@RequiredArgsConstructor
public class CustomerServis {

   /* @Autowired*//* @Repository olduğu için  buna gerek kalmadı */
    private final CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;

    public Customer getCustomer(){
        return null;
    }

    public Optional<Customer> saveCustomer(CustomerDTO customerDTO) throws RuntimeException {

        if(customerDAO.isExitSsid(customerDTO.getSsid())){
            throw new SameCustomerException(" customerDTO with ssid " + customerDTO.getSsid()+" is already existed??");
        }
/*        Customer customer1=new Customer();
   *//*     customer1.setId*//*
        customer1.setId(customer1.getSsid());
        customer1.setEmail(customerDTO.getEmail());
        customer1.setFirstName(customerDTO.getFirstName());
        customer1.setLastName(customerDTO.getLastName());
        customer1.setSsid(customerDTO.getSsid());*/
        Customer customer1=customerMapper.mapFromCustomerDTOToCustomer(customerDTO);

        return Optional.ofNullable(customerDAO.save(customer1));
    }
}
