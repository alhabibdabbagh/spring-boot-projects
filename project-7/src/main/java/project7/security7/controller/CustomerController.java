package project7.security7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;
import project7.security7.servics.CustomerServis;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Habib
 * @on 10/14/21 - 11:31 AM
 */
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerServis customerServis;

    @PostMapping("/save-customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO){
      Optional<Customer> optionalCustomer= customerServis.saveCustomer(customerDTO);
      if(optionalCustomer.isPresent()){
          return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
