package project7.security7.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;
import project7.security7.servics.CustomerServis;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @Mock
    CustomerServis mockCustomerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    void saveCustomer() {

        // given
        Customer customer = new Customer();
        customer.setSsid(11111L);
        Optional<Customer> expected = Optional.of(customer);
        when(mockCustomerService.saveCustomer(any())).thenReturn(expected);

        // when
        CustomerDTO dto = new CustomerDTO();
        Customer actual = this.customerController.saveCustomer(dto).getBody();

        // then
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual),
                () -> assertEquals(customer.getSsid(), actual.getSsid())
        );
    }

    }