package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.domain.Customer;
import dev.fujioka.java.avancado.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CrudInterface<Customer> {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> save(Customer entity) {
        return Optional.of(customerRepository.save(entity));
    }

    @Override
    public void delete(Customer entity) { customerRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) { customerRepository.deleteById(id);
    }

    @Override
    public long count() { return customerRepository.count();
    }

    public Customer findByPhone(String phone) {
        return customerRepository.findCustomerByPhone(phone);
    }

    public List<Customer> findPhoneBySubString(String phone) {
        return customerRepository.findCustomersPhoneBySubstring(phone);
    }

    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomersBysName(name);
    }

    public List<Customer> findNameBySubString(String name) {
        return customerRepository.findCustomersNameBYSubstring(name);
    }
    public void deleteByName(String name){
        customerRepository.deleteByName(name);
    }
}
