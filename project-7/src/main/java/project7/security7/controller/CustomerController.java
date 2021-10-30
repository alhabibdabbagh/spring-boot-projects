package project7.security7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project7.security7.dto.CustomerDTO;
import project7.security7.entity.Customer;
import project7.security7.servics.CustomerServis;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Objects;
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
    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomerWithId(@RequestParam long id){
       Customer customer= customerServis.getCustomerById((long)id);
        if(Objects.nonNull(customer)){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PutMapping("/customer/update")
    public ResponseEntity<Customer> updateCustomerWithId(@RequestBody @Valid CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer= customerServis.updateCustomer(customerDTO);
        if(Objects.nonNull(optionalCustomer)){

            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<Customer> customerResponseEntity (@RequestParam long id){
       // Customer customer =customerServis.getCustomerById(customerId);
        customerServis.deleteById((long)id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
