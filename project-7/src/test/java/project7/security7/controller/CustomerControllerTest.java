package project7.security7.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project7.security7.servics.CustomerServis;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
     CustomerServis customerServisMockito;

    @InjectMocks
    CustomerController customerController;




    @Test
    void saveCustomer() {
    }
}