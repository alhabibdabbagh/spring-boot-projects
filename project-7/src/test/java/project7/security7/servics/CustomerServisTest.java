package project7.security7.servics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;
import project7.security7.exceptions.BadRequestException;
import project7.security7.exceptions.SameCustomerException;
import project7.security7.mapper.CustomerMapper;
import project7.security7.mapper.WalletMapper;
import project7.security7.repository.CustomerDAO;
import project7.security7.repository.WalletRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class CustomerServisTest {

    @InjectMocks
    private CustomerServis customerServis;

    @Mock
    private CustomerMapper customerMapperMock;

    @Mock
    private CustomerDAO customerDAOMock;
    @Test
    void saveCustomer() {

        //given

        Customer customer= new Customer();
        Optional optionalCustomer=Optional.ofNullable(customer);
        Mockito.when(customerDAOMock.isExitSsid(anyLong())).thenReturn(Boolean.FALSE);
        Mockito.when(customerMapperMock.mapFromCustomerDTOToCustomer(any())).thenReturn(customer);
        Mockito.when(customerDAOMock.save(any())).thenReturn(customer);

        // when
        CustomerDTO customerDTO=new CustomerDTO();
        Customer actual=this.customerServis.saveCustomer(customerDTO).get();

        //then
        assertAll(
                ()->assertNotNull(actual),
                ()->assertEquals(customer,actual)

        );
    }

    @Test
    void saveCustomerForException(){
        Customer customer=new Customer();
        CustomerDTO customerDTO=new CustomerDTO();

        Mockito.when(customerDAOMock.isExitSsid(anyLong())).thenReturn(Boolean.TRUE);


        Executable executable =()->this.customerServis.saveCustomer(customerDTO).get();

        assertThrows(SameCustomerException.class, executable);


    }
}