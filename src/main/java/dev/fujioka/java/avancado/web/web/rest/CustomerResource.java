package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Customer;
import dev.fujioka.java.avancado.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource  {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/customer")
    public List<Customer> getCustomerList(){

        return customerService.findAll();
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        customer = customerService.save(customer).get();

        return ResponseEntity.ok().body(customer);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        customer = customerService.save(customer).get();

        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/customer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer){

        customerService.delete(customer);

        return ResponseEntity.ok().body("Cliente Excluido" + customer.getId());
    }
    @GetMapping("/customer/by-phone/{phone}")
    public ResponseEntity<?> findByPhone(@PathVariable String phone){
        return new ResponseEntity<>(customerService.findByPhone(phone), HttpStatus.OK);
    }

    @GetMapping("/customer/substringphone/{substring}")
    public ResponseEntity<?> findPhoneBySubstring(@PathVariable String substring){
        return new ResponseEntity<>(customerService.findPhoneBySubString(substring), HttpStatus.OK);
    }

    @GetMapping("/customer/by-name/{name}")
    public ResponseEntity<?> findCustomersByName(@PathVariable String name) {
        return new ResponseEntity<>(customerService.findCustomerByName(name), HttpStatus.OK);

    }

    @GetMapping("/customer/substringname/{substring}")
    public ResponseEntity<?> findNameBySubstring(@PathVariable String substring){
        return new ResponseEntity<>(customerService.findNameBySubString(substring), HttpStatus.OK);
    }

    @DeleteMapping("/customer/deletebyname/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        customerService.deleteByName(name);
        return new ResponseEntity<>("Cliente Excluido " + name, HttpStatus.OK);
    }
}
